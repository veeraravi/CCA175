hive << EOF
ALTER TABLE email2dgk_retail_db.order_items_ext CHANGE COLUMN order_item_subtotla order_item_subtotal DECIMAL
;
EOF
