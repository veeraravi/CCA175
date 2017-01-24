import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by gdevaraj on 1/18/17.
  */
object order_items {

  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setMaster("local[2]").setAppName("order_items")
    val sc  = new SparkContext(conf)

    val orderItemsFile = "/Users/gdevaraj/pcdng/pcd-workflow/etl-pcd/src/test/scala/com/premierinc/renaissance/spark/exploreNew/input/order_items.txt"

    val orderItemsRdd = sc.textFile(orderItemsFile).map(_.split(","))

    val orderIdsRdd = orderItemsRdd.map{case(z) => (z(1).toInt, (z(1).toInt,z(4).toDouble))}.sortByKey(true)

    orderIdsRdd.reduceByKey{
      case(x,y) => if (x._2 > y._2) x else y
    }.foreach{case(x,y) => println(x + ":" + y._2)}

  }

}