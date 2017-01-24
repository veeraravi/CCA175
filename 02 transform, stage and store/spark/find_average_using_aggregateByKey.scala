
val prodFile = "/user/email2dgk/review/spark/data/prod_sales_rows.txt"
val prodKvRdd = sc.textFile(prodFile).map{x=> val z= x.split(","); (z(0), z(1).toInt)}

val prodGroupedRdd= prodKvRdd.aggregateByKey((0,0))((x,y)=> (x._1 + y, x._2 +1), (x,y) => (x._1 + y._1, x._2 + y._2))
prodGroupedRdd.foreach{ case(p,(t,c)) => val avg = t.toInt/ c.toInt; println(s"Product: $p Average $avg")}



