sqoop export \
--connect "jdbc:mysql://nn01.itversity.com:3306/retail_export" \
--username retail_dba \
--password itversity \
--table departments_revenue \
--export-dir hdfs://nn01.itversity.com:8020/apps/hive/warehouse/email2dgk_mysql_retail_db.db/departments_revenue \
-m 2
