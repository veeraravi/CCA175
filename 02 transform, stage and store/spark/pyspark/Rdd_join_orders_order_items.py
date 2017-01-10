from pyspark import SparkContext, SparkConf

conf = SparkConf().setAppName("Rdd_join_orders_order_items.py").setMaster("local[2]")
sc = SparkContext(conf=conf)


logger = sc._jvm.org.apache.log4j
logger.LogManager.getLogger("org"). setLevel( logger.Level.ERROR )
logger.LogManager.getLogger("akka").setLevel( logger.Level.ERROR )

class orders(object):
	def __init__(self,order_id,order_date,order_customer_id,order_status):
		self.order_id=order_id
		self.order_date=order_date
		self.order_customer_id=order_customer_id
		self.order_status=order_status
	def showOrders(self):
		print "orderID: ", self.order_id, "OrderDate:", self.order_date,
		"OrderCustomer:", self.order_customer_id, "OrderStatus:", self.order_status
class order_items(object):
	def __init__(self,order_item_id,order_item_order_id,order_item_product_id,
	order_item_quanity,order_item_subtotal,order_item_product_price):
		self.order_item_id = order_item_id
		self.order_item_order_id = order_item_order_id
		self.order_item_product_id=order_item_product_id
		self.order_item_quanity=order_item_quanity
		self.order_item_subtotal = order_item_subtotal
		self.order_item_product_price = order_item_product_price
		
	def showOrderItems(self):
		print "order_item_id: ", self.order_item_id, "order_item_order_id: ", 
		self.order_item_order_id

		
		
## Program invocation starts from here
ordersFile="/user/cloudera/cca175/retail_db/orders"
orderItemsFile="/user/cloudera/cca175/retail_db/order_items"
		
#ordersRdd = sc.textFile(ordersFile).map(lambda inp: t= inp.split(",")  (t[0], orders(t[0],t[1],t[2],t[3])))
#orderItemsRdd = sc.textFile(orderItemsFile).map(lambda inp: t= inp.split(",")   (t[0], orders(t[0],t[1],t[2],t[3],t[4],t[5])))

#ordersRdd = sc.textFile(ordersFile).map(lambda inp: (inp.split(",")[0], orders(inp.split(",")[0],inp.split(",")[1],inp.split(",")[2],inp.split(",")[3])))
ordersRdd = sc.textFile(ordersFile).map(lambda inp:  orders(inp.split(",")[0],inp.split(",")[1],inp.split(",")[2],inp.split(",")[3]))
#orderItemsRdd = sc.textFile(orderItemsFile).map(lambda inp: (inp.split(",")[0], order_items(inp.split(",")[0],inp.split(",")[1],inp.split(",")[2],inp.split(",")[3],inp.split(",")[4],inp.split(",")[5])))
orderItemsRdd = sc.textFile(orderItemsFile).map(lambda inp: order_items(inp.split(",")[0],inp.split(",")[1],inp.split(",")[2],inp.split(",")[3],inp.split(",")[4],inp.split(",")[5]))

ordersCount = ordersRdd.count()
orderItemsCount = orderItemsRdd.count()

print("Total No.of Records in Orders File %s = %d "  %(ordersFile, ordersCount))
print("Total No.of Records in Order_items File %s = %d "  %(orderItemsFile, orderItemsCount))
"""
print "Sample records from ordersRdd"
for rec in ordersRdd.take(5):
	print rec.showOrders()
print "Sample Records from OrderItemsRdd"
for rec in orderItemsRdd.take(5):
	print rec.showOrderItems()
"""
ordersRdd.foreach(lambda x: x.showOrders())

orderItemsRdd.foreach(lambda x: x.showOrderItems())

sc.stop()

#spark-submit --master local[2] Rdd_join_orders_order_items.py