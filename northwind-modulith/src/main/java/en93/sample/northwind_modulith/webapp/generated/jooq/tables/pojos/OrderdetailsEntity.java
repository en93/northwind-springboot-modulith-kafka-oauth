/*
 * This file is generated by jOOQ.
 */
package en93.sample.northwind_modulith.webapp.generated.jooq.tables.pojos;


import java.io.Serializable;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public class OrderdetailsEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private final Integer orderdetailid;
    private final Integer orderid;
    private final Integer productid;
    private final Integer quantity;

    public OrderdetailsEntity(OrderdetailsEntity value) {
        this.orderdetailid = value.orderdetailid;
        this.orderid = value.orderid;
        this.productid = value.productid;
        this.quantity = value.quantity;
    }

    public OrderdetailsEntity(
        Integer orderdetailid,
        Integer orderid,
        Integer productid,
        Integer quantity
    ) {
        this.orderdetailid = orderdetailid;
        this.orderid = orderid;
        this.productid = productid;
        this.quantity = quantity;
    }

    /**
     * Getter for <code>public.orderdetails.orderdetailid</code>.
     */
    public Integer getOrderdetailid() {
        return this.orderdetailid;
    }

    /**
     * Getter for <code>public.orderdetails.orderid</code>.
     */
    public Integer getOrderid() {
        return this.orderid;
    }

    /**
     * Getter for <code>public.orderdetails.productid</code>.
     */
    public Integer getProductid() {
        return this.productid;
    }

    /**
     * Getter for <code>public.orderdetails.quantity</code>.
     */
    public Integer getQuantity() {
        return this.quantity;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final OrderdetailsEntity other = (OrderdetailsEntity) obj;
        if (this.orderdetailid == null) {
            if (other.orderdetailid != null)
                return false;
        }
        else if (!this.orderdetailid.equals(other.orderdetailid))
            return false;
        if (this.orderid == null) {
            if (other.orderid != null)
                return false;
        }
        else if (!this.orderid.equals(other.orderid))
            return false;
        if (this.productid == null) {
            if (other.productid != null)
                return false;
        }
        else if (!this.productid.equals(other.productid))
            return false;
        if (this.quantity == null) {
            if (other.quantity != null)
                return false;
        }
        else if (!this.quantity.equals(other.quantity))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.orderdetailid == null) ? 0 : this.orderdetailid.hashCode());
        result = prime * result + ((this.orderid == null) ? 0 : this.orderid.hashCode());
        result = prime * result + ((this.productid == null) ? 0 : this.productid.hashCode());
        result = prime * result + ((this.quantity == null) ? 0 : this.quantity.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("OrderdetailsEntity (");

        sb.append(orderdetailid);
        sb.append(", ").append(orderid);
        sb.append(", ").append(productid);
        sb.append(", ").append(quantity);

        sb.append(")");
        return sb.toString();
    }
}
