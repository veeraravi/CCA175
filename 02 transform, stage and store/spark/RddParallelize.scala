import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf

import org.apache.log4j.Logger
import org.apache.log4j.Level

object RddParallelize {
 def main(args:Array[String])
  {
        Logger.getLogger("org").setLevel(Level.ERROR)
	Logger.getLogger("akka").setLevel(Level.ERROR)

	val conf = new SparkConf().setAppName("RddParalleize")
	val sc = new SparkContext(conf)

	val input:Array[Int] = Array(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15)
	val inputRdd = sc.parallelize(input)

        println("inputRDD")
	inputRdd.foreach(println)

        println("Multiples of 5 only ")
	inputRdd.filter(_%5 == 0).foreach(println)
 
        println("Multiplied by 10")
	inputRdd.map(x=> x*10).foreach(println)

        println("Key-Value Pair ")
	inputRdd.map{x=> (x,10000)}.foreach(println)

	val sum = inputRdd.reduce(_+_)
        println("Sum is " + sum)	


        def add10(n:Int):Int = n+10

        val increase10 = (n:Int) => n+10

        println("add10() ")
        inputRdd.map(add10).foreach(println)

        println("Increase10")
        inputRdd.map(increase10).foreach(println)
   
       

	sc.stop()
  }
}
