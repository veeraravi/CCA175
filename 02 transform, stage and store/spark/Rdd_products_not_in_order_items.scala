import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf
import org.apache.log4j.{Logger, Level}

object Rdd_products_not_in_order_items {
def main(args:Array[String]){

        Logger.getLogger("org").setLevel(Level.ERROR)
	Logger.getLogger("akka").setLevel(Level.ERROR)

        val conf = new SparkConf().setAppName("RddProudctsNotInOrderItems")
	val sc = new SparkContext(conf)

	val products = sc.textFile("/user/cloudera/cca175/retail_db/products")
	val orderItems = sc.textFile("/user/cloudera/cca175/retail_db/order_items")

        val productsRdd = products.map{x=> (x.split(",")(0).toInt,0)}.distinct
	val orderItemsRdd  = orderItems.map{x=> (x.split(",")(2).toInt,0)}.distinct

	val joinedRdd = productsRdd.leftOuterJoin(orderItemsRdd)

	val onlyInProducts = joinedRdd.filter{case(k,(y,z))=> z == None}.map{case(k,(y,z)) => k} 
        println(onlyInProducts.count() + " products are not present in the Order_items")
        
        onlyInProducts.saveAsTextFile("/user/cloudera/cca175/spark/data/output/products_not_in_order_items")

	sc.stop()



}
}