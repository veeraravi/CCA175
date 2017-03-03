sqoop import \
--connect "jdbc:mysql://nn01.itversity.com:3306/retail_import"  \
--username retail_dba \
--password itversity \
--table custs \
--target-dir /user/email2dgk/review/mysql/data/retail_import/custs \
--num-mappers 5
