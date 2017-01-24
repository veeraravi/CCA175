val prodFile = "/user/email2dgk/review/spark/data/prod_sales_rows.txt"
val prodKvRdd = sc.textFile(prodFile).map{x=> val z= x.split(","); (z(0), z(1).toInt)}

val prodCountRdd = prodKvRdd.map{case(p,s) => (p,1)}.reduceByKey(_+_)
val prodSalesRdd = prodKvRdd.reduceByKey(_+_)
prodSalesRdd.leftOuterJoin(prodCountRdd)

prodSalesRdd.leftOuterJoin(prodCountRdd).foreach{ 
case(k,(s,someC))=> val count = someC.fold(1)(_.toInt); 
val avg = s.toInt/count.toInt; 
println(k + ":"+ avg)}

from pyspark import SparkConf,SparkContext,SQLContext

orders
