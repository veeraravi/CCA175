import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf


object RddReduceByKeyOrderItems {

def main(args: Array[String]){

        val conf = new SparkConf().setAppName("RddReduceByKeyOrderItems")
	val sc  = new SparkContext(conf)

	val orderItemsRdd = sc.textFile("/user/cloudera/cca175/retail_db/order_items")

	println("Total No.of Orders in the Order_items.txt are ")
	
	val results = orderItemsRdd.map{x=> (x.split(",")(1).toInt, x.split(",")(3).toInt)}.reduceByKey(_+_).sortByKey(true).saveAsTextFile("/user/cloudera/cca175/spark/data/output/order_items_grouped_by_orders_id")
        //results.foreach{case(x,y)=> println("Order ID " + x + " have " + y + " items")}

        sc.stop()
}


}
