hive << EOF
USE email2dgk_retail_db;
DROP TABLE IF EXISTS custs_external;
CREATE EXTERNAL TABLE custs_external
(
 id INT,
 fname STRING,
 lname STRING,
 address STRING,
 city STRING,
 zip STRING
)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
STORED AS TEXTFILE
LOCATION '/user/email2dgk/review2/mysql/data/custs';

EOF
