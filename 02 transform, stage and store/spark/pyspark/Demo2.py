from pyspark import SparkContext

sc= SparkContext("local","Demo2.py")
inputFile = "/user/cloudera/cca175/retail_db/products"
inputRdd = sc.textFile(inputFile)
inputCount = inputRdd.count()

print "Total No.of Records in %s file is %i" %(inputFile, inputCount)
sc.stop()

//Invocation 
//spark-submit --master local[2] Demo2.py