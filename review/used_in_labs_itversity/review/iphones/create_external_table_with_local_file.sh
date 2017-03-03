hive << EOF
USE email2dgk_retail_db;
DROP TABLE IF EXISTS iphones_new;
CREATE EXTERNAL TABLE iphones_new (model STRING, soldout InT)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
STORED AS TEXTFILE
LOCATION '/user/email2dgk/iphones';
EOF
