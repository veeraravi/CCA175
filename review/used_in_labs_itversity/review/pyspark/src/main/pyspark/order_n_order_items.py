from pyspark import SparkConf,SparkContext
#conf = SparkConf().setMaster("local[2]").setAppName("join.py")
conf = SparkConf().setMaster("yarn-client").setAppName("join.py")
sc = SparkContext(conf=conf)

ordersFile = "/user/email2dgk/review/mysql/data/retail_db/orders"
orderItemsFile = "/user/email2dgk/review/mysql/data/retail_db/order_items"

ordersRdd = sc.textFile(ordersFile).map(lambda x: x.split(","))
ordersKvRdd = ordersRdd.map(lambda x: (str(x[1]), 1))
ordersPairRdd = ordersRdd.map(lambda x: (str(x[1]), int(x[0])))

ordersKvTotalRdd = ordersKvRdd.reduceByKey(lambda x,y: x+y)

orderItemsRdd = sc.textFile(orderItemsFile).map(lambda x: x.split(","))

#sum of subtotal per Order_item_order_id
orderItemsKvRdd = orderItemsRdd.map(lambda x: (int(x[1]), float(x[4])))
orderItemsKvTotalRdd = orderItemsKvRdd.reduceByKey(lambda x,y: x+y)

ordersKeysRdd = ordersPairRdd.map(lambda (x,y): (y,(y,x)))
orderItemsKeysRdd = orderItemsKvTotalRdd.map(lambda (x,y): (x,(x,y)))
joinedRdd = orderItemsKeysRdd.join(ordersKeysRdd)

print "Samples from joinedRdd"

for i in joinedRdd.take(5):
	print i

sc.stop()
