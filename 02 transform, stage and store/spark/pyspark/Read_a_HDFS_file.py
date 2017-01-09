from pyspark import SparkConf, SparkContext

conf = SparkConf().setAppName("Read_a_HDFS_file.py").setMaster("local[2]")
sc = SparkContext(conf=conf)

inputFile = "/user/cloudera/cca175/spark/data/input/student_basic.txt"

inputRdd = sc.textFile(inputFile)

print "Totla No.of Records in %s is %i" %(inputFile, inputRdd.count())

maleRdd = inputRdd.filter(lambda s: s )

sc.stop()





