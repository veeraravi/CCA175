from pyspark import SparkContext, SparkConf
conf = SparkConf().setMaster("local[2]").setAppName("retail_db_order_items.py")
sc = SparkContext(conf=conf)

orderItemsFile="/user/email2dgk/review/mysql/data/retail_db/order_items"
orderItemsRdd = sc.textFile(orderItemsFile)

recCount = orderItemsRdd.count()

print "Total No.of Records = %d " %(recCount)

orderIdsRdd = orderItemsRdd.map(lambda line: (int(line.split(",")[1]), 0.0 if line.split(",")[4] == "" else float(line.split(",")[4])))

orderIdsTotalRdd = orderIdsRdd.reduceByKey(lambda pid,sales: pid + sales).sortByKey()

orderIdsWithMaxRdd = orderIdsRdd.reduceByKey(lambda x,y: (x if x[1] >= y[1] else y)).sortByKey()

print "Sample of 10 Order IDs and Sales"
for rec in orderIdsRdd.take(10):
	print rec[0], rec[1]

print "Cumulative sales per Order ID"
for rec in orderIdsTotalRdd.take(10):
	print rec[0], rec[1]

print "Max sales per Order IDs"
for rec in orderIdsWtihMaxRdd.take(10):
	print rec[0], rec[1]

sc.stop()
