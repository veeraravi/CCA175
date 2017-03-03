hive << EOF
USE email2dgk_retail_db;

CREATE EXTERNAL TABLE orders_ext
( 
order_id INT,
order_date STRING,
order_customer_id INT,
order_status STRING
)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
STORED AS TEXTFILE
LOCATION '/user/email2dgk/review/mysql/data/retail_db/orders';

CREATE TABLE orders
( 
order_id INT,
order_date STRING,
order_customer_id INT,
order_status STRING
)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
STORED AS TEXTFILE;
EOF
