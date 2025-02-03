package en93.sample.northwindmodulith.webapp.entities;


import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "products")
public class ProductsEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    @Column(name = "productID")
    private Integer productID;
    @Column(name = "productName")
    private String productName;
    @Column(name = "supplierID")
    private Integer supplierID;//todo change to object of supplier
    @Column(name = "categoryID")
    private Integer categoryID; //todo change as well
    @Column(name = "unit")
    private String unit;
    @Column(name = "price")
    private BigDecimal price;//todo is this the optimal type for money?

    public ProductsEntity() {
    }

    public ProductsEntity(Integer productID, String productName, Integer supplierID, Integer categoryID, String unit, BigDecimal price) {
        this.productID = productID;
        this.productName = productName;
        this.supplierID = supplierID;
        this.categoryID = categoryID;
        this.unit = unit;
        this.price = price;
    }

    public Integer getProductID() {
        return productID;
    }

    public void setProductID(Integer productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(Integer supplierID) {
        this.supplierID = supplierID;
    }

    public Integer getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(Integer categoryID) {
        this.categoryID = categoryID;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ProductsEntity that = (ProductsEntity) o;
        return Objects.equals(productID, that.productID) && Objects.equals(productName, that.productName) && Objects.equals(supplierID, that.supplierID) && Objects.equals(categoryID, that.categoryID) && Objects.equals(unit, that.unit) && Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productID, productName, supplierID, categoryID, unit, price);
    }

    @Override
    public String toString() {
        return "ProductsEntity{" +
                "productID=" + productID +
                ", productName='" + productName + '\'' +
                ", supplierID=" + supplierID +
                ", categoryID=" + categoryID +
                ", unit='" + unit + '\'' +
                ", price=" + price +
                '}';
    }
}
