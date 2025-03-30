
package en93.sample.northwindmodulith.webapp.entities;


import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "suppliers")
public class SupplierEntity {


    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    @Column(name = "supplierID")
    private Integer supplierID;
    @Column(name = "supplierKey")
    private String supplierKey;
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

    public SupplierEntity() {
    }

    public SupplierEntity(Integer supplierID, String supplierKey, String supplierName, String contactName, String address, String city, String postalCode, String country, String phone) {
        this.supplierID = supplierID;
        this.supplierKey = supplierKey;
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

    public String getSupplierKey() {
        return supplierKey;
    }

    public void setSupplierKey(String supplierKey) {
        this.supplierKey = supplierKey;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        SupplierEntity that = (SupplierEntity) o;
        return Objects.equals(supplierID, that.supplierID) && Objects.equals(supplierKey, that.supplierKey) && Objects.equals(supplierName, that.supplierName) && Objects.equals(contactName, that.contactName) && Objects.equals(address, that.address) && Objects.equals(city, that.city) && Objects.equals(postalCode, that.postalCode) && Objects.equals(country, that.country) && Objects.equals(phone, that.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(supplierID, supplierKey, supplierName, contactName, address, city, postalCode, country, phone);
    }

    @Override
    public String toString() {
        return "SupplierEntity{" +
                "supplierID=" + supplierID +
                ", supplierKey='" + supplierKey + '\'' +
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
