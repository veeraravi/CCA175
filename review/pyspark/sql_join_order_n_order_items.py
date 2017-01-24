from pyspark import SparkConf,SparkContext,SQLContext,Row

conf = SparkConf().setAppName("join.py")
sc = SparkContext(conf=conf)
sqlsc = SQLContext(sc)

ordersFile = "/user/cloudera/cca175/retail_db/orders"
order_itemsFile = "/user/cloudera/cca175/retail_db/order_items"

ordersRdd = sc.textFile(ordersFile).map(lambda l: l.split(","))
order_itemsRdd = sc.textFile(order_itemsFile).map(lambda x:x.split(","))

ordersKvRdd = ordersRdd.map(lambda x:(Row(orderid= int(x[0]), odate=str(x[1]), custid=int(x[2]),status = str(x[3]))))

orderItemsKvRdd = order_itemsRdd.map(lambda x: (Row(itemid=int(x[0]), orderid=int(x[0]))))

schemaOrders = sqlsc.inferSchema(ordersKvRdd)
schemaOrderItems = sqlsc.inferSchema(orderItemsKvRdd)

schemaOrders.registerTempTable("orders")
schemaOrderItems.registerTempTable("order_items")

ordersCount = sqlsc.sql("select count(*) as x from orders")
orderItemsCount = sqlsc.sql("select count(*) as x from order_items")

orderStatus = sqlsc.sql("select distinct status from orders")

ordersJoin = sqlsc.sql("select count(distinct x.orderid) as z from order_items x join orders y on x.orderid = y.orderid")

orderMatchCount = ordersJoin.map(lambda obj:obj.z).collect()

print "<<<<>>>> Total No.of Match orders     %s " %(orderMatchCount)

orderStatusRdd = orderStatus.map(lambda x:" Order Status " + x.status)

print "Disintct Order Status are "

for rec in orderStatusRdd.collect():
        print rec

for i in ordersCount.collect():
        print i.x

for i in orderItemsCount.collect():
        print i.x


#print "Total No.of Records in order Table        %s " %(ordersCount)
#print "Total No.of Records in order_items Table  %s " %(orderItemsCount)

sc.stop()



