hive << EOF
use email2dgk_mysql_retail_db;

LOAD DATA INPATH '/user/email2dgk/review/spark/data/input/employeejson' INTO TABLE employee_json;

