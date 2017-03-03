hive << EOF
USE email2dgk_retail_db;

DROP TABLE IF EXISTS customers;

CREATE TABLE email2dgk_retail_db.customers(id INT,
fname STRING,
lname STRING,
address STRING,
city STRING,
zip STRING)
partitioned BY (state STRING)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
STORED AS TEXTFILE;

DESCRIBE FORMATTED customers;

SELECT COUNT(*) FROM customers;

EOF
