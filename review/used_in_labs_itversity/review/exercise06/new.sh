sqoop import-all-tables  \
--connect "jdbc:mysql://nn01.itversity.com:3306/retail_db" \
--username retail_dba \
--password itversity \
--warehouse-dir /user/email2dgk/retail_data_jan17 \
-m 2
