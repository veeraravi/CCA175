hive << EOF
USE email2dgk_mysql_retail_db;

DROP TABLE if exists student;

CREATE TABLE student
(name STRING,
 city STRING)
ROW FORMAT SERDE 'org.apache.hive.hcatalog.data.JsonSerDe'
STORED AS TEXTFILE;

DROP TABLE if exists student_ext;
create external table if not exists student_ext
(
name string,
city string)
ROW FORMAT SERDE 'org.apache.hive.hcatalog.data.JsonSerDe'
STORED AS TEXTFILE
LOCATION '/user/email2dgk/review/spark/data/input/student_json';

select count(*) from student_ext;

select * from student_ext;

INSERT INTO student
SELECT * FROM student_ext;

SELECT * FROM student;

EOF
