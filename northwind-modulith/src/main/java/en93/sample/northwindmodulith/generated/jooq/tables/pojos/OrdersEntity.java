/*
 * This file is generated by jOOQ.
 */
package en93.sample.northwindmodulith.generated.jooq.tables.pojos;


import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public class OrdersEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private final Integer orderid;
    private final Integer customerid;
    private final Integer employeeid;
    private final LocalDateTime orderdate;
    private final Integer shipperid;

    public OrdersEntity(OrdersEntity value) {
        this.orderid = value.orderid;
        this.customerid = value.customerid;
        this.employeeid = value.employeeid;
        this.orderdate = value.orderdate;
        this.shipperid = value.shipperid;
    }

    public OrdersEntity(
        Integer orderid,
        Integer customerid,
        Integer employeeid,
        LocalDateTime orderdate,
        Integer shipperid
    ) {
        this.orderid = orderid;
        this.customerid = customerid;
        this.employeeid = employeeid;
        this.orderdate = orderdate;
        this.shipperid = shipperid;
    }

    /**
     * Getter for <code>public.orders.orderid</code>.
     */
    public Integer getOrderid() {
        return this.orderid;
    }

    /**
     * Getter for <code>public.orders.customerid</code>.
     */
    public Integer getCustomerid() {
        return this.customerid;
    }

    /**
     * Getter for <code>public.orders.employeeid</code>.
     */
    public Integer getEmployeeid() {
        return this.employeeid;
    }

    /**
     * Getter for <code>public.orders.orderdate</code>.
     */
    public LocalDateTime getOrderdate() {
        return this.orderdate;
    }

    /**
     * Getter for <code>public.orders.shipperid</code>.
     */
    public Integer getShipperid() {
        return this.shipperid;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final OrdersEntity other = (OrdersEntity) obj;
        if (this.orderid == null) {
            if (other.orderid != null)
                return false;
        }
        else if (!this.orderid.equals(other.orderid))
            return false;
        if (this.customerid == null) {
            if (other.customerid != null)
                return false;
        }
        else if (!this.customerid.equals(other.customerid))
            return false;
        if (this.employeeid == null) {
            if (other.employeeid != null)
                return false;
        }
        else if (!this.employeeid.equals(other.employeeid))
            return false;
        if (this.orderdate == null) {
            if (other.orderdate != null)
                return false;
        }
        else if (!this.orderdate.equals(other.orderdate))
            return false;
        if (this.shipperid == null) {
            if (other.shipperid != null)
                return false;
        }
        else if (!this.shipperid.equals(other.shipperid))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.orderid == null) ? 0 : this.orderid.hashCode());
        result = prime * result + ((this.customerid == null) ? 0 : this.customerid.hashCode());
        result = prime * result + ((this.employeeid == null) ? 0 : this.employeeid.hashCode());
        result = prime * result + ((this.orderdate == null) ? 0 : this.orderdate.hashCode());
        result = prime * result + ((this.shipperid == null) ? 0 : this.shipperid.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("OrdersEntity (");

        sb.append(orderid);
        sb.append(", ").append(customerid);
        sb.append(", ").append(employeeid);
        sb.append(", ").append(orderdate);
        sb.append(", ").append(shipperid);

        sb.append(")");
        return sb.toString();
    }
}
