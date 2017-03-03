from pyspark import SparkConf, SparkContext
conf = SparkConf().setMaster("local[2]").setAppName("orders.py")
sc = SparkContext(conf=conf)

ordersFile="/user/email2dgk/review/mysql/data/retail_db/orders"
ordersRdd = sc.textFile(ordersFile).map(lambda line: line.split(","))
ordersCount = ordersRdd.count()
completedOrdersCount = ordersRdd.filter(lambda z: str(z[3]) == 'COMPLETE').count()
distinctOrderStatus = ordersRdd.map(lambda z: z[3]).distinct()

ordersStatusRdd = ordersRdd.map(lambda z: (str(z[3]),1))

ordersStatusCountsRdd = ordersStatusRdd.reduceByKey(lambda s,c: s+c)
#orgdersStatusAggreRdd = ordersStatusRdd.aggregateByKey((0)((lambda x,y: x+y),(lambda x,y:x+y)))

orderDateStatusRdd = ordersRdd.map(lambda z:(str(z[1]) + str(z[3]),1))

orderDatesCountRdd = orderDateStatusRdd.reduceByKey(lambda s,c: s+c)

print "<<<>>>File : %s have %d  orders" %(ordersFile, ordersCount)
print "<<<>>>File : %s have %d  completed Orders " %(ordersFile, completedOrdersCount)
print "<<<>>>File  %s have the following order statuses " %(ordersFile)
for status in distinctOrderStatus.collect():
	print status

for stats in ordersStatusCountsRdd.collect():
	print "Order Status : %s and Record %s" %(stats[0], stats[1])
'''
for stats in ordersStatusAggreRdd.collect():
	print "Order Status : %s and Record %s" %(stats[0], stats[1])
'''
for stats in orderDatesCountRdd.collect():
	print stats

sc.stop()

#order_id, date, customer_id, status
