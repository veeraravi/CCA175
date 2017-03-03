hive << EOF
USE email2dgk_retail_db;

CREATE EXTERNAL TABLE IF NOT EXISTS departments_external 
(
 department_id INT,
 department_name STRING
)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
STORED AS TEXTFILE
LOCATION '/user/email2dgk/review/mysql/data/retail_db/departments';

CREATE TABLE IF NOT EXISTS departments
AS SELECT * FROM departments_external;

SELECT count(*) from departments_external; 
SELECT count(*) from departments;
 
EOF
