from pyspark import SparkContext, SparkConf

# Read a file from HDFS and write back to HDFS
conf = SparkConf().setAppName("Rdd_word_count.py").setMaster("local[2]")
sc = SparkContext(conf=conf)

inputFile = "/user/cloudera/cca175/retail_db/orders"
inputRdd = sc.textFile(inputFile)

outputRdd = inputRdd.flatMap(lambda x: x.split(",")).map(lambda x: (x,1)).reduceByKey(lambda x,y: x +y)
outputRdd.saveAsTextFile("/user/cloudera/cca175/spark/output/orders_word_count_using_pyspark")

# Create a sc.paralleize RDD and write into HDFS as a text File

months = ["Jan","Feb","Mar","Mar","Mar","Jan","Jan","Jul","Jul","Jul","Feb","Dec","Aug","Aug"]
monthsRdd = sc.parallelize(months,2)
monthsRdd.saveAsTextFile("/user/cloudera/cca175/spark/input/months")

inputRdd = sc.textFile("/user/cloudera/cca175/spark/input/months")

inputRdd.flatMap(lambda line: line.split(" ")).map(lambda word:(word,1)).reduceByKey(lambda x,y:x+y).saveAsTextFile("/user/cloudera/cca175/spark/output/months_word_count")

sc.stop()


#spark-submit --master local[2] Rdd_word_count.py 