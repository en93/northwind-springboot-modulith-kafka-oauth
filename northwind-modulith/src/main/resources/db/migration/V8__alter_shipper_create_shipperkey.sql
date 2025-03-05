--Make idempotent if rerun, clear previous data back to initial state
ALTER TABLE shippers
DROP COLUMN IF EXISTS shipperkey;

--New surrogate key for keys exposed outside of application
ALTER TABLE shippers
ADD COLUMN shipperkey varchar(50);

--Set values for existing shipper
UPDATE shippers
SET shipperkey = 'SHPPR-' || uuid_generate_v4()
WHERE shipperkey IS NULL;

--Require not null and unique
ALTER TABLE shippers
ALTER COLUMN shipperkey SET NOT NULL,
ADD CONSTRAINT unique_shipper_key UNIQUE (shipperkey);
