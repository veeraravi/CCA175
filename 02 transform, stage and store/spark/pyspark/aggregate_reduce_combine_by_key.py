words = ["Jan","Feb","Mar","Mar","Apr","May","May","May","Dec","Dec","Feb","Apr","Nov","Oct"]
wordsRdd = sc.parallelize(words)

wordCountRdd = wordsRdd.map(lambda x: (x,1)).reduceByKey(lambda x,y: x+y)

wordAggreRdd = wordsRdd.map(lambda x:(x,1)).aggregateByKey((0,0),(lambda x,y:(x[0]+y, x[1]+1)),(lambda x,y:(x[0]+y[0], x[1]+y[1])))

wordsRdd.map(lambda x:(x,1)).aggregateByKey((0,0),(lambda x,y: (x+y)),(lambda x,y: (x+y))).collect()

def sum(a,b):
	return a+b
	
wordCombineRdd = wordsRdd.map(lambda x:(x,1)).combineByKey(lambda x:x, sum, sum)

wordCombineByKeyRdd = wordsRdd.map(lambda x:(x,1)).combineByKey(lambda x,y:x,y, lambda x,y:)

for i in wordCountRdd.collect():
	print "Word : %s Found : %d times " %(i[0], i[1])
	
for i in wordCombineRdd.collect():
	print "Word : %s Found : %d times " %(i[0], i[0][1])
	
# Average By using aggregateByKey
products = [("A",100),("B",200),("A",100),("B",200),("C",1000)]
productsRdd = sc.parallelize(products)
productsTotalRdd = productsRdd.aggregateByKey((0,0),(lambda x,y:(x[0]+y, x[1]+1)),(lambda x,y:(x[0]+y[0],x[1]+y[1])))
productsAvgRdd = productsTotalRdd.map(lambda x: (x[0],int(x[1][0]/x[1][1])))
for i in productsAvgRdd.collect():
	print i

# Average By using reduceByKey
products = [("A",100),("B",200),("A",100),("B",200),("C",1000)]
productsRdd = sc.parallelize(products)
productsKvRdd = productsRdd.map(lambda (x,y): (x,(y,1)))
productsReduceTotalRdd=productsKvRdd.reduceByKey(lambda x,y: (x[0]+y[0],x[1]+y[1]))
productsReduceAvgRdd = productsReduceTotalRdd.map(lambda x: (x[0], int(x[1][0]/x[1][1])))

#Average By using CombineByKey
products = [("A",100),("B",200),("A",100),("B",200),("C",1000)]
productsRdd = sc.parallelize(products)
productsKvRdd = productsRdd.map(lambda (x,y): (x,(y,1)))
productsCombineTotalRdd = productsKvRdd.combineByKey(lambda x:)


