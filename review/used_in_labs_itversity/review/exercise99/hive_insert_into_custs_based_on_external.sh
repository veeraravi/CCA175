hive <<  EOF
USE email2dgk_retail_db;

INSERT INTO TABLE custs partition(state="NJ")
SELECT * FROM custs_external where city="New Jersy City";

INSERT INTO TABLE custs partition(state="NY")
SELECT * FROM custs_external where city="New york City";
EOF
