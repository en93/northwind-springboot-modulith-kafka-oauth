ALTER TABLE products
DROP COLUMN IF EXISTS tsv_content;

ALTER TABLE products
ADD COLUMN tsv_content TSVECTOR
GENERATED ALWAYS AS (
    setweight(to_tsvector('english', productname), 'A') ||
    setweight(to_tsvector('english', unit), 'B')
) STORED;

CREATE INDEX idx_prouduct_fts ON products USING GIN(tsv_content);
