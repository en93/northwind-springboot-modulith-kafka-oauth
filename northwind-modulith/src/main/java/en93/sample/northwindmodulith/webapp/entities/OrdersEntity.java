package en93.sample.northwindmodulith.webapp.entities;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "orders")
public class OrdersEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    @Column(name = "orderID")
    private Integer orderID;
    @Column(name = "customerID")
    private Integer customerID;
    @Column(name = "employeeID")
    private Integer employeeID; //todo change type
    @Column(name = "orderDate")
    private LocalDateTime orderDate;
    @Column(name = "shipperID")
    private Integer shipperID; //todo chagne to shipper obj

    public OrdersEntity() {
    }

    public OrdersEntity(Integer orderID, Integer customerID, Integer employeeID, LocalDateTime orderDate, Integer shipperID) {
        this.orderID = orderID;
        this.customerID = customerID;
        this.employeeID = employeeID;
        this.orderDate = orderDate;
        this.shipperID = shipperID;
    }

    public Integer getOrderID() {
        return orderID;
    }

    public void setOrderID(Integer orderID) {
        this.orderID = orderID;
    }

    public Integer getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Integer customerID) {
        this.customerID = customerID;
    }

    public Integer getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(Integer employeeID) {
        this.employeeID = employeeID;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public Integer getShipperID() {
        return shipperID;
    }

    public void setShipperID(Integer shipperID) {
        this.shipperID = shipperID;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        OrdersEntity that = (OrdersEntity) o;
        return Objects.equals(orderID, that.orderID) && Objects.equals(customerID, that.customerID) && Objects.equals(employeeID, that.employeeID) && Objects.equals(orderDate, that.orderDate) && Objects.equals(shipperID, that.shipperID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderID, customerID, employeeID, orderDate, shipperID);
    }

    @Override
    public String toString() {
        return "OrdersEntity{" +
                "orderID=" + orderID +
                ", customerID=" + customerID +
                ", employeeID=" + employeeID +
                ", orderDate=" + orderDate +
                ", shipperID=" + shipperID +
                '}';
    }
}
