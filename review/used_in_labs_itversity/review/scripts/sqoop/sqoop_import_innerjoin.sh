sqoop import --connect "jdbc:mysql://nn01.itversity.com:3306/retail_db" \
--username retail_dba \
--password itversity \
--query 'SELECT T1.order_id, T2.order_item_product_id, T1.order_status FROM orders T1 INNER JOIN order_items T2 ON T1.order_id = T2.order_item_order_id WHERE $CONDITIONS' \
--split-by T1.order_id \
--target-dir /user/email2dgk/review/mysql/orders_n_items \
--delete-target-dir \
--num-mappers 4
