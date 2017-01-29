sqoop export \
--connect "jdbc:mysql://nn01.itversity.com:3306/retail_export" \
--username retail_dba \
--password itversity \
--table student_basic \
--export-dir /user/email2dgk/review/spark/data/input/student_basic \
--input-lines-terminated-by "\n" \
--input-fields-terminated-by "," \
-m 5
