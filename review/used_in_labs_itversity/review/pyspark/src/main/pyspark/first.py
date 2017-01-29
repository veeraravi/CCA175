from pyspark import SparkContext, SparkConf
conf = SparkConf().setMaster("local[2]").setAppName("First.py")
sc = SparkContext(conf=conf)

logger = sc._jvm.org.apache.log4j
logger.LogManager.getLogger("org"). setLevel( logger.Level.ERROR )
logger.LogManager.getLogger("akka").setLevel( logger.Level.ERROR )

print "Sc.version is %s" %(sc.version)

nosRdd = sc.parallelize([1,2,3,4,5])

for no in nosRdd.collect():
	print "%d \n" %(no)

sc.stop()

