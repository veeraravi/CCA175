sqoop import \
--connect "jdbc:mysql://nn01.itversity.com:3306/retail_db" \
--username retail_dba \
--password itversity \
--hive-import \
--create-hive-table \
--table orders \
--hive-database email2dgk_mysql_retail_db \
--hive-table orders_sqooped \
--fields-terminated-by '|' \
-m 2
