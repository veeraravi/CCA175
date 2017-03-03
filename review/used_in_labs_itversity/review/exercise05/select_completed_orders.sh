hive << EOF

USE email2dgk_retail_db.orders_ext;

SELECT COUNT(*) FROM email2dgk_retail_db.orders_ext WHERE order_status = "COMPLETE";

FROM email2dgk_retail_db.orders_ext
INSERT OVERWRITE DIRECTORY '/user/email2dgk/review/hive/data/completed_orders_only'
SELECT * 
WHERE order_status = "COMPLETE"
INSERT OVERWRITE DIRECTORY '/user/email2dgk/review/hive/data/cancelled_orders_only'
SELECT * 
WHERE order_status = "CANCELED";

EOF
