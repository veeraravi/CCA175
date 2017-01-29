hive << EOF
CREATE DATABASE IF NOT EXISTS email2dgk_retail_db;

USE email2dgk_retail_db;

CREATE TABLE IF NOT EXISTS categories_avro
STORED AS AVRO
TBLPROPERTIES('avro.schema.url'='/user/email2dgk/review/mysql/schema/categories.avsc');

CREATE EXTERNAL TABLE IF NOT EXISTS categories_avro_ext
STORED AS AVRO
LOCATION '/user/email2dgk/review/mysql/data/categories_as_avro'
TBLPROPERTIES('avro.schema.url'='/user/email2dgk/review/mysql/schema/categories.avsc');

INSERT INTO categories_avro
SELECT * FROM categories_avro_ext;

EOF

