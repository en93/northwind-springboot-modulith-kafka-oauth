package en93.sample.northwindmodulith.webapp.entities;


import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;


public class ShippersEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    @Column(name = "shipperID")
    private Integer shipperID;
    @Column(name = "shipperName")
    private String shipperName;
    @Column(name = "phone")
    private String phone;

    public ShippersEntity() {
    }

    public ShippersEntity(Integer shipperID, String shipperName, String phone) {
        this.shipperID = shipperID;
        this.shipperName = shipperName;
        this.phone = phone;
    }

    public Integer getShipperID() {
        return shipperID;
    }

    public void setShipperID(Integer shipperID) {
        this.shipperID = shipperID;
    }

    public String getShipperName() {
        return shipperName;
    }

    public void setShipperName(String shipperName) {
        this.shipperName = shipperName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ShippersEntity that = (ShippersEntity) o;
        return Objects.equals(shipperID, that.shipperID) && Objects.equals(shipperName, that.shipperName) && Objects.equals(phone, that.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shipperID, shipperName, phone);
    }

    @Override
    public String toString() {
        return "ShippersEntity{" +
                "shipperID=" + shipperID +
                ", shipperName='" + shipperName + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
