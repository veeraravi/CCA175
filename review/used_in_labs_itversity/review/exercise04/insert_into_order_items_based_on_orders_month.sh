hive << EOF
USE email2dgk_retail_db;

set hive.exec.dynamic.partition.mode=nonstrict;

INSERT INTO order_items PARTITION(orders_month)
SELECT T1.order_item_id,
T1.order_item_order_id,
T1.order_item_product_id,
T1.order_item_quantity,
T1.order_item_subtotal,
T1.order_item_product_price,
substr(T2.order_date,1,7) as orders_month
FROM order_items_ext T1
LEFT JOIN orders_ext T2
ON T1.order_item_order_id = T2.order_id;

EOF
