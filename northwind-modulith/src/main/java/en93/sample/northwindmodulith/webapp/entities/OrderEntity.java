package en93.sample.northwindmodulith.webapp.entities;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "orders")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    @Column(name = "orderID")
    private Integer orderID;
    @Column(name = "orderKey")
    private String orderKey;
    @ManyToOne
    @JoinColumn(name = "customerID")
    private CustomerEntity customer;
    @ManyToOne
    @JoinColumn(name = "employeeID")
    private EmployeeEntity employee;
    @Column(name = "orderDate")
    private LocalDateTime orderDate;
    @ManyToOne
    @JoinColumn(name = "shipperID")
    private ShipperEntity shipper;
    @OneToMany(mappedBy = "orderID", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderDetailEntity> details;

    public OrderEntity() {
    }

    public OrderEntity(Integer orderID, String orderKey, CustomerEntity customer, EmployeeEntity employee, LocalDateTime orderDate, ShipperEntity shipper, List<OrderDetailEntity> details) {
        this.orderID = orderID;
        this.orderKey = orderKey;
        this.customer = customer;
        this.employee = employee;
        this.orderDate = orderDate;
        this.shipper = shipper;
        this.details = details;
    }

    public Integer getOrderID() {
        return orderID;
    }

    public void setOrderID(Integer orderID) {
        this.orderID = orderID;
    }

    public CustomerEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerEntity customer) {
        this.customer = customer;
    }

    public EmployeeEntity getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeEntity employee) {
        this.employee = employee;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public ShipperEntity getShipper() {
        return shipper;
    }

    public void setShipper(ShipperEntity shipper) {
        this.shipper = shipper;
    }

    public List<OrderDetailEntity> getDetails() {
        return details;
    }

    public void setDetails(List<OrderDetailEntity> details) {
        this.details = details;
    }

    public String getOrderKey() {
        return orderKey;
    }

    public void setOrderKey(String orderKey) {
        this.orderKey = orderKey;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        OrderEntity that = (OrderEntity) o;
        return Objects.equals(orderID, that.orderID) && Objects.equals(orderKey, that.orderKey) && Objects.equals(customer, that.customer) && Objects.equals(employee, that.employee) && Objects.equals(orderDate, that.orderDate) && Objects.equals(shipper, that.shipper) && Objects.equals(details, that.details);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderID, orderKey, customer, employee, orderDate, shipper, details);
    }

    @Override
    public String toString() {
        return "OrderEntity{" +
                "orderID=" + orderID +
                ", orderKey=" + orderKey +
                ", customer=" + customer +
                ", employee=" + employee +
                ", orderDate=" + orderDate +
                ", shipper=" + shipper +
                ", details=" + details +
                '}';
    }
}
