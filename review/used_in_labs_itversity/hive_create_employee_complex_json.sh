hive << EOF
USE email2dgk_mysql_retail_db;

DROP TABLE IF EXISTS employee_complex_json;

CREATE TABLE IF NOT EXISTS employee_complex_json
(
 empjson ARRAY<STRUCT<ename: STRING, eage:INT, ecity : STRING, ezip:INT>>
)
ROW FORMAT SERDE 'org.apache.hive.hcatalog.data.JsonSerDe'
STORED AS TEXTFILE;

LOAD DATA INPATH '/user/email2dgk/review/spark/data/input/employeejson' INTO TABLE employee_complex_json;

EOF


