hive << EOF
USE email2dgk_retail_db;

DROP TABLE IF EXISTS custs;

CREATE TABLE email2dgk_retail_db.custs(id INT,
fname STRING,
lname STRING,
address STRING,
city STRING,
zip STRING)
partitioned BY (state STRING)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
STORED AS TEXTFILE;

DESCRIBE FORMATTED custs;

SELECT COUNT(*) FROM custs;

EOF
