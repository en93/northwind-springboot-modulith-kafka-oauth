package en93.sample.northwindmodulith.webapp.entities;


import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "products")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    @Column(name = "productID")
    private Integer productID;
    @Column(name = "productKey")
    private String productKey;
    @Column(name = "productName")
    private String productName;
    @ManyToOne
    @JoinColumn(name = "supplierID")
    private SupplierEntity supplier;
    @ManyToOne
    @JoinColumn(name = "categoryID")
    private CategoryEntity category;
    @Column(name = "unit")
    private String unit;
    @Column(name = "price")
    private BigDecimal price;

    public ProductEntity() {
    }

    public ProductEntity(Integer productID, String productKey, String productName, SupplierEntity supplier, CategoryEntity category, String unit, BigDecimal price) {
        this.productID = productID;
        this.productKey = productKey;
        this.productName = productName;
        this.supplier = supplier;
        this.category = category;
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

    public SupplierEntity getSupplier() {
        return supplier;
    }

    public void setSupplier(SupplierEntity supplier) {
        this.supplier = supplier;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
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

    public String getProductKey() {
        return productKey;
    }

    public void setProductKey(String productKey) {
        this.productKey = productKey;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ProductEntity that = (ProductEntity) o;
        return Objects.equals(productID, that.productID) && Objects.equals(productKey, that.productKey) && Objects.equals(productName, that.productName) && Objects.equals(supplier, that.supplier) && Objects.equals(category, that.category) && Objects.equals(unit, that.unit) && Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productID, productKey, productName, supplier, category, unit, price);
    }

    @Override
    public String toString() {
        return "ProductEntity{" +
                "productID=" + productID +
                ", productKey='" + productKey + '\'' +
                ", productName='" + productName + '\'' +
                ", supplier=" + supplier +
                ", category=" + category +
                ", unit='" + unit + '\'' +
                ", price=" + price +
                '}';
    }
}
