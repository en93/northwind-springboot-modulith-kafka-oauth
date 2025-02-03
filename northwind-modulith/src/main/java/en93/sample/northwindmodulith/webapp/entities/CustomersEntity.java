
package en93.sample.northwindmodulith.webapp.entities;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "customers")
public class CustomersEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    @Column(name = "customerID")
    private Integer customerID;
    @Column(name = "customerName")
    private String customerName;
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

    public CustomersEntity() {}

    public CustomersEntity(Integer customerID, String customerName, String contactName, String address, String city, String postalCode, String country) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.contactName = contactName;
        this.address = address;
        this.city = city;
        this.postalCode = postalCode;
        this.country = country;
    }

    public Integer getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Integer customerID) {
        this.customerID = customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CustomersEntity that = (CustomersEntity) o;
        return Objects.equals(customerID, that.customerID) && Objects.equals(customerName, that.customerName) && Objects.equals(contactName, that.contactName) && Objects.equals(address, that.address) && Objects.equals(city, that.city) && Objects.equals(postalCode, that.postalCode) && Objects.equals(country, that.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerID, customerName, contactName, address, city, postalCode, country);
    }

    @Override
    public String toString() {
        return "CustomersEntity{" +
                "customerID=" + customerID +
                ", customerName='" + customerName + '\'' +
                ", contactName='" + contactName + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", country='" + country + '\'' +
                '}';
    }


}
