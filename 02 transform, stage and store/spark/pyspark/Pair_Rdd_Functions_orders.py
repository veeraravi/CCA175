from pyspark import SparkContext, SparkConf

conf = SparkConf().setAppName("Pair_Rdd_Functions_orders.py").setMaster("local[2]")
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
		print "orderID: ", self.orderID, "OrderDate:", self.order_date,
			"OrderCustomer:", self.order_customer_id, "OrderStatus:", self.order_status
			

#main method 