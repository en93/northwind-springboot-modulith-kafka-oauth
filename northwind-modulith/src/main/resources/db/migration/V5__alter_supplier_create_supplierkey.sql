--Make idempotent if rerun, clear previous data back to initial state
ALTER TABLE suppliers
DROP COLUMN IF EXISTS supplierkey;

--New surrogate key for keys exposed outside of application
ALTER TABLE suppliers
ADD COLUMN supplierkey varchar(50);

--Set values for existing suppliers
UPDATE suppliers
SET supplierkey = 'SUPP-' || uuid_generate_v4()
WHERE supplierkey IS NULL;

--Require not null and unique
ALTER TABLE suppliers
ALTER COLUMN supplierkey SET NOT NULL,
ADD CONSTRAINT unique_supplier_key UNIQUE (supplierkey);
