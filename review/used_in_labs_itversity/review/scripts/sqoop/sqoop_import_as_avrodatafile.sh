sqoop import -Dmapreduce.job.user.classpath.first=true  \
--connect "jdbc:mysql://nn01.itversity.com:3306/retail_db" \
--username retail_dba \
--password itversity \
--table categories \
--target-dir /user/email2dgk/review/mysql/data/categories_as_avro \
--as-avrodatafile \
--delete-target-dir \
--num-mappers 5
