hive <<  EOF
USE email2dgk_retail_db;
set hive.exec.dynamic.partition=true;
set hive.exec.dynamic.partition.mode=nonstrict;
INSERT INTO TABLE customers partition(state)
SELECT * FROM customers_external;
EOF
