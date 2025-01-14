/*
 * This file is generated by jOOQ.
 */
package en93.sample.northwindmodulith.generated.jooq.tables;


import en93.sample.northwindmodulith.generated.jooq.Keys;
import en93.sample.northwindmodulith.generated.jooq.Public;
import en93.sample.northwindmodulith.generated.jooq.tables.ProductsTable.ProductsPath;
import en93.sample.northwindmodulith.generated.jooq.tables.records.SuppliersRecord;

import java.util.Collection;

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
public class SuppliersTable extends TableImpl<SuppliersRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.suppliers</code>
     */
    public static final SuppliersTable SUPPLIERS = new SuppliersTable();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<SuppliersRecord> getRecordType() {
        return SuppliersRecord.class;
    }

    /**
     * The column <code>public.suppliers.supplierid</code>.
     */
    public final TableField<SuppliersRecord, Integer> SUPPLIERID = createField(DSL.name("supplierid"), SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>public.suppliers.suppliername</code>.
     */
    public final TableField<SuppliersRecord, String> SUPPLIERNAME = createField(DSL.name("suppliername"), SQLDataType.VARCHAR(50), this, "");

    /**
     * The column <code>public.suppliers.contactname</code>.
     */
    public final TableField<SuppliersRecord, String> CONTACTNAME = createField(DSL.name("contactname"), SQLDataType.VARCHAR(50), this, "");

    /**
     * The column <code>public.suppliers.address</code>.
     */
    public final TableField<SuppliersRecord, String> ADDRESS = createField(DSL.name("address"), SQLDataType.VARCHAR(50), this, "");

    /**
     * The column <code>public.suppliers.city</code>.
     */
    public final TableField<SuppliersRecord, String> CITY = createField(DSL.name("city"), SQLDataType.VARCHAR(20), this, "");

    /**
     * The column <code>public.suppliers.postalcode</code>.
     */
    public final TableField<SuppliersRecord, String> POSTALCODE = createField(DSL.name("postalcode"), SQLDataType.VARCHAR(10), this, "");

    /**
     * The column <code>public.suppliers.country</code>.
     */
    public final TableField<SuppliersRecord, String> COUNTRY = createField(DSL.name("country"), SQLDataType.VARCHAR(15), this, "");

    /**
     * The column <code>public.suppliers.phone</code>.
     */
    public final TableField<SuppliersRecord, String> PHONE = createField(DSL.name("phone"), SQLDataType.VARCHAR(15), this, "");

    private SuppliersTable(Name alias, Table<SuppliersRecord> aliased) {
        this(alias, aliased, (Field<?>[]) null, null);
    }

    private SuppliersTable(Name alias, Table<SuppliersRecord> aliased, Field<?>[] parameters, Condition where) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table(), where);
    }

    /**
     * Create an aliased <code>public.suppliers</code> table reference
     */
    public SuppliersTable(String alias) {
        this(DSL.name(alias), SUPPLIERS);
    }

    /**
     * Create an aliased <code>public.suppliers</code> table reference
     */
    public SuppliersTable(Name alias) {
        this(alias, SUPPLIERS);
    }

    /**
     * Create a <code>public.suppliers</code> table reference
     */
    public SuppliersTable() {
        this(DSL.name("suppliers"), null);
    }

    public <O extends Record> SuppliersTable(Table<O> path, ForeignKey<O, SuppliersRecord> childPath, InverseForeignKey<O, SuppliersRecord> parentPath) {
        super(path, childPath, parentPath, SUPPLIERS);
    }

    /**
     * A subtype implementing {@link Path} for simplified path-based joins.
     */
    public static class SuppliersPath extends SuppliersTable implements Path<SuppliersRecord> {

        private static final long serialVersionUID = 1L;
        public <O extends Record> SuppliersPath(Table<O> path, ForeignKey<O, SuppliersRecord> childPath, InverseForeignKey<O, SuppliersRecord> parentPath) {
            super(path, childPath, parentPath);
        }
        private SuppliersPath(Name alias, Table<SuppliersRecord> aliased) {
            super(alias, aliased);
        }

        @Override
        public SuppliersPath as(String alias) {
            return new SuppliersPath(DSL.name(alias), this);
        }

        @Override
        public SuppliersPath as(Name alias) {
            return new SuppliersPath(alias, this);
        }

        @Override
        public SuppliersPath as(Table<?> alias) {
            return new SuppliersPath(alias.getQualifiedName(), this);
        }
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Public.PUBLIC;
    }

    @Override
    public Identity<SuppliersRecord, Integer> getIdentity() {
        return (Identity<SuppliersRecord, Integer>) super.getIdentity();
    }

    @Override
    public UniqueKey<SuppliersRecord> getPrimaryKey() {
        return Keys.SUPPLIERS_PKEY;
    }

    private transient ProductsPath _products;

    /**
     * Get the implicit to-many join path to the <code>public.products</code>
     * table
     */
    public ProductsPath products() {
        if (_products == null)
            _products = new ProductsPath(this, null, Keys.PRODUCTS__PRODUCTS_SUPPLIERID_FKEY.getInverseKey());

        return _products;
    }

    @Override
    public SuppliersTable as(String alias) {
        return new SuppliersTable(DSL.name(alias), this);
    }

    @Override
    public SuppliersTable as(Name alias) {
        return new SuppliersTable(alias, this);
    }

    @Override
    public SuppliersTable as(Table<?> alias) {
        return new SuppliersTable(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public SuppliersTable rename(String name) {
        return new SuppliersTable(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public SuppliersTable rename(Name name) {
        return new SuppliersTable(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public SuppliersTable rename(Table<?> name) {
        return new SuppliersTable(name.getQualifiedName(), null);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public SuppliersTable where(Condition condition) {
        return new SuppliersTable(getQualifiedName(), aliased() ? this : null, null, condition);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public SuppliersTable where(Collection<? extends Condition> conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public SuppliersTable where(Condition... conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public SuppliersTable where(Field<Boolean> condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public SuppliersTable where(SQL condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public SuppliersTable where(@Stringly.SQL String condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public SuppliersTable where(@Stringly.SQL String condition, Object... binds) {
        return where(DSL.condition(condition, binds));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public SuppliersTable where(@Stringly.SQL String condition, QueryPart... parts) {
        return where(DSL.condition(condition, parts));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public SuppliersTable whereExists(Select<?> select) {
        return where(DSL.exists(select));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public SuppliersTable whereNotExists(Select<?> select) {
        return where(DSL.notExists(select));
    }
}