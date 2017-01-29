hive -e "CREATE DATABASE email2dgk_mysql_retail_db";

sqoop import-all-tables \
--connect "jdbc:mysql://nn01.itversity.com:3306/retail_db" \
--username retail_dba \
--password itversity \
--hive-import \
--hive-database email2dgk_mysql_retail_db \
--hive-overwrite \
-m 2
