hive<< EOF
USE email2dgk_retail_db;

ALTER TABLE customers DROP IF EXISTS PARTITION(state="CA");

EOF
