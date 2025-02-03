
package en93.sample.northwindmodulith.webapp.entities;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "suppliers")
public class SuppliersEntity {


    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    @Column(name = "supplierID")
    private Integer supplierID;
    @Column(name = "supplierName")
    private String supplierName;
    @Column(name = "contactName")
    private String contactName;
    @Column(name = "address")
    private String address;
    @Column(name = "city")
    private String city;
    @Column(name = "postalCode")
    private String postalCode;
    @Column(name = "country")
    private String country;
    @Column(name = "phone")
    private String phone;

    public SuppliersEntity() {
    }

    public SuppliersEntity(Integer supplierID, String supplierName, String contactName, String address, String city, String postalCode, String country, String phone) {
        this.supplierID = supplierID;
        this.supplierName = supplierName;
        this.contactName = contactName;
        this.address = address;
        this.city = city;
        this.postalCode = postalCode;
        this.country = country;
        this.phone = phone;
    }

    public Integer getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(Integer supplierID) {
        this.supplierID = supplierID;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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
        SuppliersEntity that = (SuppliersEntity) o;
        return Objects.equals(supplierID, that.supplierID) && Objects.equals(supplierName, that.supplierName) && Objects.equals(contactName, that.contactName) && Objects.equals(address, that.address) && Objects.equals(city, that.city) && Objects.equals(postalCode, that.postalCode) && Objects.equals(country, that.country) && Objects.equals(phone, that.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(supplierID, supplierName, contactName, address, city, postalCode, country, phone);
    }

    @Override
    public String toString() {
        return "SuppliersEntity{" +
                "supplierID=" + supplierID +
                ", supplierName='" + supplierName + '\'' +
                ", contactName='" + contactName + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", country='" + country + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
