--Make idempotent if rerun, clear previous data back to initial state
ALTER TABLE orders
DROP COLUMN IF EXISTS orderkey;

--New surrogate key for keys exposed outside of application
ALTER TABLE orders
ADD COLUMN orderkey varchar(50);

--Set values for existing customers
UPDATE orders
SET orderkey = 'ORDR-' || uuid_generate_v4()
WHERE orderkey IS NULL;

--Require not null and unique
ALTER TABLE orders
ALTER COLUMN orderkey SET NOT NULL,
ADD CONSTRAINT unique_order_key UNIQUE (orderkey);
