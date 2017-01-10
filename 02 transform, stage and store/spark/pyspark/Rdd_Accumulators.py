from pyspark import SparkConf, SparkContext

conf = SparkConf().setAppName("Rdd_Accumulators.py").setMaster("local[2]")
sc = SparkContext(conf=conf)

numbers = [1,2,3,4,5,6,7,8,9,10]
numbersRdd = sc.parallelize(numbers)

# Declaration of Accumulator 
sumAccum = sc.accumulator(0)

sumWithOutAccum = numbersRdd.reduce(lambda x,y: x+y)

#numbersRdd.foreach(lambda x: sumAccum.add(x))

numbersRdd.foreach(lambda x: sumAccum.add(x))
print("SumWithAccum is %d " %(sumAccum.value))
print("sumWithOutAccum is %d " %(sumWithOutAccum))

sc.stop()

