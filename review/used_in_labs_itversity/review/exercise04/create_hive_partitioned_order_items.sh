hive << EOF
USE email2dgk_retail_db;

CREATE EXTERNAL TABLE order_items_ext
(
order_item_id INT,
order_item_order_id INT,
order_item_product_id INT,
order_item_quantity INT,
order_item_subtotal DECIMAL,
order_item_product_price DECIMAL
)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
STORED AS TEXTFILE
LOCATION '/user/email2dgk/review/mysql/data/retail_db/order_items';

CREATE TABLE order_items
(
order_item_id INT,
order_item_order_id INT,
order_item_product_id INT,
order_item_quantity INT,
order_item_subtotal DECIMAL,
order_item_product_price DECIMAL
)
PARTITIONED BY (orders_month STRING)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
STORED AS TEXTFILE;
EOF
