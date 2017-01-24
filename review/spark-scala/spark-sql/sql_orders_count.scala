import org.apache.spark.SparkContext
import org.apache.spark.SparkConf
import org.apache.spark.sql.SQLContext

object sql_orders_count
{

  def main(args: Array[String]) {

       val conf = new SparkConf().setAppName("SQL")
       val sc = new SparkContext(conf)
       val sqlsc = new SQLContext(sc)

        import sqlsc.createSchemaRDD

        val ordersFile = "/user/cloudera/cca175/retail_db/orders"
        val ordersRdd  = sc.textFile(ordersFile).map(_.split(","))

         case class orderschema(oid:Int,odate:String,ocustid:Int,ostatus:String)

        val orderSchemaRdd = ordersRdd.map(x=> new orderschema(x(0).toInt,x(1),x(2).toInt,x(3)))

        orderSchemaRdd.registerTempTable("orders")

        println("Total No.of Orders")

        val ordersCount = sqlsc.sql("Select count(*) from orders")

        ordersCount.foreach(println)

        sc.stop()


 }
}
