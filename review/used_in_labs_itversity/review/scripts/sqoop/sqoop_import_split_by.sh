sqoop import --connect "jdbc:mysql://nn01.itversity.com:3306/retail_db" \
--username retail_dba \
--password itversity \
--query 'select T1.order_date,T1.order_customer_id,T1.order_status from orders T1 where $CONDITIONS' \
--split-by T1.order_id \
--target-dir /user/email2dgk/review/mysql/split-by \
--delete-target-dir \
-m 5
