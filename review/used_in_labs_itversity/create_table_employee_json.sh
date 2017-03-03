hive << EOF
USE email2dgk_mysql_retail_db;

DROP TABLE IF EXISTS employee_json;

CREATE TABLE IF NOT EXISTS employee_json
( ename STRING,
  eage INT,
  ecity STRING,
  ezip INT
)
ROW FORMAT SERDE 'org.apache.hive.hcatalog.data.JsonSerDe'
STORED AS TEXTFILE;

EOF
