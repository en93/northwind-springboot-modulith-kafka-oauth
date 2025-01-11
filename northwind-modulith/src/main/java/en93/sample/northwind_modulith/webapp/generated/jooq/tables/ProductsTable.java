/*
 * This file is generated by jOOQ.
 */
package en93.sample.northwind_modulith.webapp.generated.jooq.tables;


import en93.sample.northwind_modulith.webapp.generated.jooq.Keys;
import en93.sample.northwind_modulith.webapp.generated.jooq.Public;
import en93.sample.northwind_modulith.webapp.generated.jooq.tables.CategoriesTable.CategoriesPath;
import en93.sample.northwind_modulith.webapp.generated.jooq.tables.OrderdetailsTable.OrderdetailsPath;
import en93.sample.northwind_modulith.webapp.generated.jooq.tables.SuppliersTable.SuppliersPath;
import en93.sample.northwind_modulith.webapp.generated.jooq.tables.records.ProductsRecord;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.jooq.Condition;
import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.InverseForeignKey;
import org.jooq.Name;
import org.jooq.Path;
import org.jooq.PlainSQL;
import org.jooq.QueryPart;
import org.jooq.Record;
import org.jooq.SQL;
import org.jooq.Schema;
import org.jooq.Select;
import org.jooq.Stringly;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public class ProductsTable extends TableImpl<ProductsRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.products</code>
     */
    public static final ProductsTable PRODUCTS = new ProductsTable();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ProductsRecord> getRecordType() {
        return ProductsRecord.class;
    }

    /**
     * The column <code>public.products.productid</code>.
     */
    public final TableField<ProductsRecord, Integer> PRODUCTID = createField(DSL.name("productid"), SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>public.products.productname</code>.
     */
    public final TableField<ProductsRecord, String> PRODUCTNAME = createField(DSL.name("productname"), SQLDataType.VARCHAR(50), this, "");

    /**
     * The column <code>public.products.supplierid</code>.
     */
    public final TableField<ProductsRecord, Integer> SUPPLIERID = createField(DSL.name("supplierid"), SQLDataType.INTEGER, this, "");

    /**
     * The column <code>public.products.categoryid</code>.
     */
    public final TableField<ProductsRecord, Integer> CATEGORYID = createField(DSL.name("categoryid"), SQLDataType.INTEGER, this, "");

    /**
     * The column <code>public.products.unit</code>.
     */
    public final TableField<ProductsRecord, String> UNIT = createField(DSL.name("unit"), SQLDataType.VARCHAR(25), this, "");

    /**
     * The column <code>public.products.price</code>.
     */
    public final TableField<ProductsRecord, BigDecimal> PRICE = createField(DSL.name("price"), SQLDataType.NUMERIC, this, "");

    private ProductsTable(Name alias, Table<ProductsRecord> aliased) {
        this(alias, aliased, (Field<?>[]) null, null);
    }

    private ProductsTable(Name alias, Table<ProductsRecord> aliased, Field<?>[] parameters, Condition where) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table(), where);
    }

    /**
     * Create an aliased <code>public.products</code> table reference
     */
    public ProductsTable(String alias) {
        this(DSL.name(alias), PRODUCTS);
    }

    /**
     * Create an aliased <code>public.products</code> table reference
     */
    public ProductsTable(Name alias) {
        this(alias, PRODUCTS);
    }

    /**
     * Create a <code>public.products</code> table reference
     */
    public ProductsTable() {
        this(DSL.name("products"), null);
    }

    public <O extends Record> ProductsTable(Table<O> path, ForeignKey<O, ProductsRecord> childPath, InverseForeignKey<O, ProductsRecord> parentPath) {
        super(path, childPath, parentPath, PRODUCTS);
    }

    /**
     * A subtype implementing {@link Path} for simplified path-based joins.
     */
    public static class ProductsPath extends ProductsTable implements Path<ProductsRecord> {

        private static final long serialVersionUID = 1L;
        public <O extends Record> ProductsPath(Table<O> path, ForeignKey<O, ProductsRecord> childPath, InverseForeignKey<O, ProductsRecord> parentPath) {
            super(path, childPath, parentPath);
        }
        private ProductsPath(Name alias, Table<ProductsRecord> aliased) {
            super(alias, aliased);
        }

        @Override
        public ProductsPath as(String alias) {
            return new ProductsPath(DSL.name(alias), this);
        }

        @Override
        public ProductsPath as(Name alias) {
            return new ProductsPath(alias, this);
        }

        @Override
        public ProductsPath as(Table<?> alias) {
            return new ProductsPath(alias.getQualifiedName(), this);
        }
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Public.PUBLIC;
    }

    @Override
    public Identity<ProductsRecord, Integer> getIdentity() {
        return (Identity<ProductsRecord, Integer>) super.getIdentity();
    }

    @Override
    public UniqueKey<ProductsRecord> getPrimaryKey() {
        return Keys.PRODUCTS_PKEY;
    }

    @Override
    public List<ForeignKey<ProductsRecord, ?>> getReferences() {
        return Arrays.asList(Keys.PRODUCTS__PRODUCTS_CATEGORYID_FKEY, Keys.PRODUCTS__PRODUCTS_SUPPLIERID_FKEY);
    }

    private transient CategoriesPath _categories;

    /**
     * Get the implicit join path to the <code>public.categories</code> table.
     */
    public CategoriesPath categories() {
        if (_categories == null)
            _categories = new CategoriesPath(this, Keys.PRODUCTS__PRODUCTS_CATEGORYID_FKEY, null);

        return _categories;
    }

    private transient SuppliersPath _suppliers;

    /**
     * Get the implicit join path to the <code>public.suppliers</code> table.
     */
    public SuppliersPath suppliers() {
        if (_suppliers == null)
            _suppliers = new SuppliersPath(this, Keys.PRODUCTS__PRODUCTS_SUPPLIERID_FKEY, null);

        return _suppliers;
    }

    private transient OrderdetailsPath _orderdetails;

    /**
     * Get the implicit to-many join path to the
     * <code>public.orderdetails</code> table
     */
    public OrderdetailsPath orderdetails() {
        if (_orderdetails == null)
            _orderdetails = new OrderdetailsPath(this, null, Keys.ORDERDETAILS__ORDERDETAILS_PRODUCTID_FKEY.getInverseKey());

        return _orderdetails;
    }

    @Override
    public ProductsTable as(String alias) {
        return new ProductsTable(DSL.name(alias), this);
    }

    @Override
    public ProductsTable as(Name alias) {
        return new ProductsTable(alias, this);
    }

    @Override
    public ProductsTable as(Table<?> alias) {
        return new ProductsTable(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public ProductsTable rename(String name) {
        return new ProductsTable(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public ProductsTable rename(Name name) {
        return new ProductsTable(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public ProductsTable rename(Table<?> name) {
        return new ProductsTable(name.getQualifiedName(), null);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public ProductsTable where(Condition condition) {
        return new ProductsTable(getQualifiedName(), aliased() ? this : null, null, condition);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public ProductsTable where(Collection<? extends Condition> conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public ProductsTable where(Condition... conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public ProductsTable where(Field<Boolean> condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public ProductsTable where(SQL condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public ProductsTable where(@Stringly.SQL String condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public ProductsTable where(@Stringly.SQL String condition, Object... binds) {
        return where(DSL.condition(condition, binds));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public ProductsTable where(@Stringly.SQL String condition, QueryPart... parts) {
        return where(DSL.condition(condition, parts));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public ProductsTable whereExists(Select<?> select) {
        return where(DSL.exists(select));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public ProductsTable whereNotExists(Select<?> select) {
        return where(DSL.notExists(select));
    }
}
