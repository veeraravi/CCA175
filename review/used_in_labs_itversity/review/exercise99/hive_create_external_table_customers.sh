hive << EOF
USE email2dgk_retail_db;
DROP TABLE IF EXISTS customers_external;
CREATE EXTERNAL TABLE customers_external
(
 id INT,
 fname STRING,
 lname STRING,
 address STRING,
 city STRING,
 zip STRING,
 state STRING
)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
STORED AS TEXTFILE
LOCATION '/user/email2dgk/review/mysql/data/retail_import/customers';

EOF
