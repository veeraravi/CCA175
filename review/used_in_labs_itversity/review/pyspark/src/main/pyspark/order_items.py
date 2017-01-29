from pyspark import SparkConf, SparkContext
conf = SparkConf().setMaster("local[2]").setAppName("Order_Items.py")
sc = SparkContext(conf=conf)

logger = sc._jvm.org.apache.log4j
logger.LogManager.getLogger("org"). setLevel( logger.Level.ERROR )
logger.LogManager.getLogger("akka").setLevel( logger.Level.ERROR )

orderItemsFile = "/user/email2dgk/review/mysql/data/retail_db/order_items"

orderItemsRdd = sc.textFile(orderItemsFile)

orderItemsCount = orderItemsRdd.count()

print "Total No.of Records in %s is  = %d " %(orderItemsFile, orderItemsCount)

sc.stop()
