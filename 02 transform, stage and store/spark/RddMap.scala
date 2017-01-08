import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf

import org.apache.log4j.Logger
import org.apache.log4j.Level

object RddMap {
 def main(args:Array[String])
  {
        Logger.getLogger("org").setLevel(Level.ERROR)
	Logger.getLogger("akka").setLevel(Level.ERROR)

	val conf = new SparkConf().setAppName("RddMap")
	val sc = new SparkContext(conf)

	val input:Array[Int] = Array(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15)
	val inputRdd = sc.parallelize(input)

        val increase10 = (x:Int) => x+10

        val toPair = (x:Int) => (x,10)
        
        inputRdd.map(increase10).foreach(println)

        println("Key-Value Pair")
        inputRdd.map(toPair).foreach(println)
   

        val monthsRdd = sc.parallelize(List("January","February","March","April","May","July","August","September","October","November","December"))
      
        val getLength = (str:String) => str.length()

        monthsRdd.map(getLength).foreach(println)
 
	sc.stop()
  }
}
