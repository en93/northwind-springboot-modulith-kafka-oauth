--Make idempotent if rerun, clear previous data back to initial state
ALTER TABLE products
DROP COLUMN IF EXISTS productkey;

--New surrogate key for keys exposed outside of application
ALTER TABLE products
ADD COLUMN productkey varchar(50);

--Set values for existing products
UPDATE products
SET productkey = 'PROD-' || uuid_generate_v4()
WHERE productkey IS NULL;

--Require not null and unique
ALTER TABLE products
ALTER COLUMN productkey SET NOT NULL,
ADD CONSTRAINT unique_product_key UNIQUE (productkey);
