from pyspark import SparkConf, SparkContext

conf = SparkConf().setAppName("Sum_of_numbers.py").setMaster("local[2]")
sc = SparkContext(conf=conf)

data = [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15]

numbersRdd = sc.parallelize(data)

sum = numbersRdd.reduce(lambda a,b: a+b)

print "Using reduce(): Sum Of given numbers is %i " %(sum)

sumAcc = sc.accumulator(0,"total")

numbersRdd.foreach(lambda x: sumAcc = sumAcc + x)

print "Using Accumulator: Sum Of given numbers is %i " %(sumAcc)