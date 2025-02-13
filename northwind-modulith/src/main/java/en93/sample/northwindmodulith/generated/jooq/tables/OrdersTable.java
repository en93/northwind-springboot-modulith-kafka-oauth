/*
 * This file is generated by jOOQ.
 */
package en93.sample.northwindmodulith.generated.jooq.tables;


import en93.sample.northwindmodulith.generated.jooq.Keys;
import en93.sample.northwindmodulith.generated.jooq.Public;
import en93.sample.northwindmodulith.generated.jooq.tables.CustomersTable.CustomersPath;
import en93.sample.northwindmodulith.generated.jooq.tables.EmployeesTable.EmployeesPath;
import en93.sample.northwindmodulith.generated.jooq.tables.OrderdetailsTable.OrderdetailsPath;
import en93.sample.northwindmodulith.generated.jooq.tables.ShippersTable.ShippersPath;
import en93.sample.northwindmodulith.generated.jooq.tables.records.OrdersRecord;

import java.time.LocalDateTime;
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
public class OrdersTable extends TableImpl<OrdersRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.orders</code>
     */
    public static final OrdersTable ORDERS = new OrdersTable();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<OrdersRecord> getRecordType() {
        return OrdersRecord.class;
    }

    /**
     * The column <code>public.orders.orderid</code>.
     */
    public final TableField<OrdersRecord, Integer> ORDERID = createField(DSL.name("orderid"), SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>public.orders.customerid</code>.
     */
    public final TableField<OrdersRecord, Integer> CUSTOMERID = createField(DSL.name("customerid"), SQLDataType.INTEGER, this, "");

    /**
     * The column <code>public.orders.employeeid</code>.
     */
    public final TableField<OrdersRecord, Integer> EMPLOYEEID = createField(DSL.name("employeeid"), SQLDataType.INTEGER, this, "");

    /**
     * The column <code>public.orders.orderdate</code>.
     */
    public final TableField<OrdersRecord, LocalDateTime> ORDERDATE = createField(DSL.name("orderdate"), SQLDataType.LOCALDATETIME(6), this, "");

    /**
     * The column <code>public.orders.shipperid</code>.
     */
    public final TableField<OrdersRecord, Integer> SHIPPERID = createField(DSL.name("shipperid"), SQLDataType.INTEGER, this, "");

    private OrdersTable(Name alias, Table<OrdersRecord> aliased) {
        this(alias, aliased, (Field<?>[]) null, null);
    }

    private OrdersTable(Name alias, Table<OrdersRecord> aliased, Field<?>[] parameters, Condition where) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table(), where);
    }

    /**
     * Create an aliased <code>public.orders</code> table reference
     */
    public OrdersTable(String alias) {
        this(DSL.name(alias), ORDERS);
    }

    /**
     * Create an aliased <code>public.orders</code> table reference
     */
    public OrdersTable(Name alias) {
        this(alias, ORDERS);
    }

    /**
     * Create a <code>public.orders</code> table reference
     */
    public OrdersTable() {
        this(DSL.name("orders"), null);
    }

    public <O extends Record> OrdersTable(Table<O> path, ForeignKey<O, OrdersRecord> childPath, InverseForeignKey<O, OrdersRecord> parentPath) {
        super(path, childPath, parentPath, ORDERS);
    }

    /**
     * A subtype implementing {@link Path} for simplified path-based joins.
     */
    public static class OrdersPath extends OrdersTable implements Path<OrdersRecord> {

        private static final long serialVersionUID = 1L;
        public <O extends Record> OrdersPath(Table<O> path, ForeignKey<O, OrdersRecord> childPath, InverseForeignKey<O, OrdersRecord> parentPath) {
            super(path, childPath, parentPath);
        }
        private OrdersPath(Name alias, Table<OrdersRecord> aliased) {
            super(alias, aliased);
        }

        @Override
        public OrdersPath as(String alias) {
            return new OrdersPath(DSL.name(alias), this);
        }

        @Override
        public OrdersPath as(Name alias) {
            return new OrdersPath(alias, this);
        }

        @Override
        public OrdersPath as(Table<?> alias) {
            return new OrdersPath(alias.getQualifiedName(), this);
        }
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Public.PUBLIC;
    }

    @Override
    public Identity<OrdersRecord, Integer> getIdentity() {
        return (Identity<OrdersRecord, Integer>) super.getIdentity();
    }

    @Override
    public UniqueKey<OrdersRecord> getPrimaryKey() {
        return Keys.ORDERS_PKEY;
    }

    @Override
    public List<ForeignKey<OrdersRecord, ?>> getReferences() {
        return Arrays.asList(Keys.ORDERS__ORDERS_CUSTOMERID_FKEY, Keys.ORDERS__ORDERS_EMPLOYEEID_FKEY, Keys.ORDERS__ORDERS_SHIPPERID_FKEY);
    }

    private transient CustomersPath _customers;

    /**
     * Get the implicit join path to the <code>public.customers</code> table.
     */
    public CustomersPath customers() {
        if (_customers == null)
            _customers = new CustomersPath(this, Keys.ORDERS__ORDERS_CUSTOMERID_FKEY, null);

        return _customers;
    }

    private transient EmployeesPath _employees;

    /**
     * Get the implicit join path to the <code>public.employees</code> table.
     */
    public EmployeesPath employees() {
        if (_employees == null)
            _employees = new EmployeesPath(this, Keys.ORDERS__ORDERS_EMPLOYEEID_FKEY, null);

        return _employees;
    }

    private transient ShippersPath _shippers;

    /**
     * Get the implicit join path to the <code>public.shippers</code> table.
     */
    public ShippersPath shippers() {
        if (_shippers == null)
            _shippers = new ShippersPath(this, Keys.ORDERS__ORDERS_SHIPPERID_FKEY, null);

        return _shippers;
    }

    private transient OrderdetailsPath _orderdetails;

    /**
     * Get the implicit to-many join path to the
     * <code>public.orderdetails</code> table
     */
    public OrderdetailsPath orderdetails() {
        if (_orderdetails == null)
            _orderdetails = new OrderdetailsPath(this, null, Keys.ORDERDETAILS__ORDERDETAILS_ORDERID_FKEY.getInverseKey());

        return _orderdetails;
    }

    @Override
    public OrdersTable as(String alias) {
        return new OrdersTable(DSL.name(alias), this);
    }

    @Override
    public OrdersTable as(Name alias) {
        return new OrdersTable(alias, this);
    }

    @Override
    public OrdersTable as(Table<?> alias) {
        return new OrdersTable(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public OrdersTable rename(String name) {
        return new OrdersTable(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public OrdersTable rename(Name name) {
        return new OrdersTable(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public OrdersTable rename(Table<?> name) {
        return new OrdersTable(name.getQualifiedName(), null);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public OrdersTable where(Condition condition) {
        return new OrdersTable(getQualifiedName(), aliased() ? this : null, null, condition);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public OrdersTable where(Collection<? extends Condition> conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public OrdersTable where(Condition... conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public OrdersTable where(Field<Boolean> condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public OrdersTable where(SQL condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public OrdersTable where(@Stringly.SQL String condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public OrdersTable where(@Stringly.SQL String condition, Object... binds) {
        return where(DSL.condition(condition, binds));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public OrdersTable where(@Stringly.SQL String condition, QueryPart... parts) {
        return where(DSL.condition(condition, parts));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public OrdersTable whereExists(Select<?> select) {
        return where(DSL.exists(select));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public OrdersTable whereNotExists(Select<?> select) {
        return where(DSL.notExists(select));
    }
}
