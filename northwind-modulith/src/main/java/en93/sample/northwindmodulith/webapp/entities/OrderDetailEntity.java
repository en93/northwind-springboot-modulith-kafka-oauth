
package en93.sample.northwindmodulith.webapp.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import java.util.Objects;



@Entity
@Table(name = "orderDetails")
public class OrderDetailEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    @Column(name = "orderDetailID")
    private Integer orderDetailID;
    @Column(name = "orderID")
    @JsonIgnore
    private Integer orderID;
    @ManyToOne
    @JoinColumn(name = "productID")
    private ProductEntity product;
    @Column(name = "quantity")
    private Integer quantity;

    public OrderDetailEntity() {
    }

    public OrderDetailEntity(Integer orderDetailID, Integer orderID, ProductEntity product, Integer quantity) {
        this.orderDetailID = orderDetailID;
        this.orderID = orderID;
        this.product = product;
        this.quantity = quantity;
    }

    public Integer getOrderDetailID() {
        return orderDetailID;
    }

    public void setOrderDetailID(Integer orderDetailID) {
        this.orderDetailID = orderDetailID;
    }

    public Integer getOrderID() {
        return orderID;
    }

    public void setOrderID(Integer orderID) {
        this.orderID = orderID;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        OrderDetailEntity that = (OrderDetailEntity) o;
        return Objects.equals(orderDetailID, that.orderDetailID) && Objects.equals(orderID, that.orderID) && Objects.equals(product, that.product) && Objects.equals(quantity, that.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderDetailID, orderID, product, quantity);
    }

    //todo re-generate
    @Override
    public String toString() {
        return "OrderdetailsEntity{" +
                "orderDetailID=" + orderDetailID +
                ", orderID=" + orderID +
                ", productID=" + product +
                ", quantity=" + quantity +
                '}';
    }
}
