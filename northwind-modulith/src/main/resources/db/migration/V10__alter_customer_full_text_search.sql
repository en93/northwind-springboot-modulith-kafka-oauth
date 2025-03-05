ALTER TABLE customers
DROP COLUMN IF EXISTS tsv_content;

ALTER TABLE customers
ADD COLUMN tsv_content TSVECTOR
GENERATED ALWAYS AS (
    setweight(to_tsvector('english', customername), 'A') ||
    setweight(to_tsvector('english', contactname), 'B') ||
    setweight(to_tsvector('english', address), 'C') ||
    setweight(to_tsvector('english', city), 'D') ||
    setweight(to_tsvector('english', postalcode), 'D') ||
    setweight(to_tsvector('english', country), 'D')
) STORED;

CREATE INDEX idx_customer_fts ON customers USING GIN(tsv_content);
