sqoop import-all-tables -Dmapreduce.job.user.classpath.first=true \
--connect "jdbc:mysql://nn01.itversity.com:3306/retail_db" \
--username retail_dba \
--password itversity \
--warehouse-dir /user/email2dgk/review/mysql/data/retail_data \
--as-avrodatafile \
-m 2
