--Make idempotent if rerun, clear previous data back to initial state
ALTER TABLE employees
DROP COLUMN IF EXISTS employeekey;

--New surrogate key for keys exposed outside of application
ALTER TABLE employees
ADD COLUMN employeekey varchar(50);

--Set values for existing employees
UPDATE employees
SET employeekey = 'EMPLY-' || uuid_generate_v4()
WHERE employeekey IS NULL;

--Require not null and unique
ALTER TABLE employees
ALTER COLUMN employeekey SET NOT NULL,
ADD CONSTRAINT unique_employee_key UNIQUE (employeekey);
