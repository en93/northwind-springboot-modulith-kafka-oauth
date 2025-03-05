--Make idempotent if rerun, clear previous data back to initial state
ALTER TABLE customers
DROP COLUMN IF EXISTS customerkey;

--New surrogate key for keys exposed outside of application
ALTER TABLE customers
ADD COLUMN customerkey varchar(50);

--Set values for existing customers
UPDATE customers
SET customerkey = 'CUST-' || uuid_generate_v4()
WHERE customerkey IS NULL;

--Require not null and unique
ALTER TABLE customers
ALTER COLUMN customerkey SET NOT NULL,
ADD CONSTRAINT unique_customer_key UNIQUE (customerkey);
