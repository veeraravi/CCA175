hive << EOF
USE email2dgk_mysql_retail_db;
DROP TABLE IF EXISTS departments_revenue;
CREATE TABLE IF NOT EXISTS departments_revenue
(
 order_date STRING,
 department_name STRING,
 revenuce DOUBLE
)
ROW FORMAT DELIMITED 
FIELDS TERMINATED BY ','
STORED AS TEXTFILE;

INSERT INTO departments_revenue
select T5.order_date, T1.department_name, sum(T4.order_item_subtotal)
FROM email2dgk_mysql_retail_db.departments T1
INNER JOIN email2dgk_mysql_retail_db.categories T2
on T1.department_id = T2.category_department_id
INNER JOIN email2dgk_mysql_retail_db.products T3
on T3.product_category_id = T2.category_id
INNER JOIN email2dgk_mysql_retail_db.order_items T4
on T4.order_item_product_id = T3.product_id
INNER JOIN email2dgk_mysql_retail_db.orders T5
on T5.order_id = T4.order_item_order_id
WHERE T5.order_status = "COMPLETE"
GROUP BY T5.order_date, T1.department_name;
EOF
