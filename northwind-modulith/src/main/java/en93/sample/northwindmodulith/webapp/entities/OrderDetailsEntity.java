
package en93.sample.northwindmodulith.webapp.entities;


import javax.persistence.*;
import java.util.Objects;



@Entity
@Table(name = "orderDetails")
public class OrderDetailsEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    @Column(name = "orderDetailID")
    private Integer orderDetailID;
    @Column(name = "orderID")
    private Integer orderID;//todo change type
    @Column(name = "productID")
    private Integer productID; //todo change type
    @Column(name = "quantity")
    private Integer quantity;

    public OrderDetailsEntity() {
    }

    public OrderDetailsEntity(Integer orderDetailID, Integer orderID, Integer productID, Integer quantity) {
        this.orderDetailID = orderDetailID;
        this.orderID = orderID;
        this.productID = productID;
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

    public Integer getProductID() {
        return productID;
    }

    public void setProductID(Integer productID) {
        this.productID = productID;
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
        OrderDetailsEntity that = (OrderDetailsEntity) o;
        return Objects.equals(orderDetailID, that.orderDetailID) && Objects.equals(orderID, that.orderID) && Objects.equals(productID, that.productID) && Objects.equals(quantity, that.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderDetailID, orderID, productID, quantity);
    }

    @Override
    public String toString() {
        return "OrderdetailsEntity{" +
                "orderDetailID=" + orderDetailID +
                ", orderID=" + orderID +
                ", productID=" + productID +
                ", quantity=" + quantity +
                '}';
    }
}
