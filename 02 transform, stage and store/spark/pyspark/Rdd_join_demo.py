from pyspark import SparkContext, SparkConf

conf = SparkConf().setAppName("Rdd_join_demo.py").setMaster("local[2]")
sc = SparkContext(conf=conf)


logger = sc._jvm.org.apache.log4j
logger.LogManager.getLogger("org"). setLevel( logger.Level.ERROR )
logger.LogManager.getLogger("akka").setLevel( logger.Level.ERROR )

file1="/user/cloudera/cca175/spark/input/file1.txt"
file2="/user/cloudera/cca175/spark/input/file2.txt"

file1Rdd = sc.textFile(file1).map(lambda s: s.split(","))
file2Rdd = sc.textFile(file2).map(lambda s: s.split(","))

file1KvRdd = file1Rdd.flatMap(lambda s: [(s[0],s[1])])
file2KvRdd = file2Rdd.flatMap(lambda s: [(s[0],s[1])])

def show(rec):
	print rec
print "Way # 1"
file1KvRdd.join(file2KvRdd).foreach(show)

print "Way # 2"
file1KvRdd.join(file2KvRdd).map(lambda (x,(y,z)): (y,z)).foreach(show)

print "Way # 3"
file1KvRdd.join(file2KvRdd).collect()

joinedRdd = file1KvRdd.join(file2KvRdd)

print "Way # 4"

for rec in joinedRdd.collect():
	print rec


sc.stop()
