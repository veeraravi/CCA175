from pyspark import SparkContext, SparkConf
conf = SparkConf().setMaster("local[2]").setAppName("order_items.py")
sc = SparkContext(conf=conf)

orderItemsFile = "/user/email2dgk/review/mysql/data/retail_db/order_items"

orderItemsRdd = sc.textFile(orderItemsFile).map(lambda line: line.split(","))

orderIdsRdd = orderItemsRdd.map(lambda z: (int(z[1]),(int(z[1]),float(z[4]))))

maxRdd = orderIdsRdd.reduceByKey(lambda x,y : x if x[1] >= y[1] else y)

maxSortedRdd = maxRdd.sortByKey(lambda x,y: x)
'''
for rec in orderIdsRdd.take(10):
	print rec

for rec in orderIdsRdd.take(10):
	print rec[0], rec[1][0] , rec[1][1]

print "Top 10 Sales Based on the Order_id"

for rec in maxRdd.take(10):
	print rec[0] , rec[1][1]
'''
print "sorted RDD"

for rec in maxSortedRdd.take(10):
	print rec[0], rec[1][1]
