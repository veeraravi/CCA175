CREATE DATABASE IF NOT EXISTS review_retail_db;

USE review_retail_db;

CREATE TABLE IF NOT EXISTS sales(
sales_id INT,
sales_date STRING,
sales_item STRING
)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
STORED AS TEXTFILE;

CREATE EXTERNAL TABLE IF NOT EXISTS sales_external(
sales_id INT,
sales_date STRING,
sales_item STRING
)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
LOCATION '/user/cloudera/cca175/review/data/input/sales';

INSERT INTO sales 
SELECT * FROM sales_external;

DROP TABLE IF EXISTS sales_external;

SELECT COUNT(*) FROM review_retail_db.sales;