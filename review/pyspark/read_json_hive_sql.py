from pyspark.sql import HiveContext
sqlContext = HiveContext(sc)
customers = sqlContext.sql("Select count(*) from email2dgk_retail_db.customers")

for i in customers.collect():
	print i
	
	
{"sid":10001, "sname" : "Adam" , "sage" : 32}
{"sid":10002, "sname" : "Bdam" , "sage" : 32}
{"sid":10003, "sname" : "Cam" , "sage" : 32}
{"sid":10004, "sname" : "Dam" , "sage" : 32}
{"sid":10005, "sname" : "Edam" , "sage" : 32}
{"sid":10006, "sname" : "Fdam" , "sage" : 32}
