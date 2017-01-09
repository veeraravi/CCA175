import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf

import org.apache.log4j.Logger
import org.apache.log4j.Level

object RddSumOfNumbers {


def main(args:Array[String]){

	Logger.getLogger("org").setLevel(Level.OFF)
	Logger.getLogger("akka").setLevel(Level.OFF)

	val conf = new SparkConf().setAppName("RddSumOfNumbers")
 	val sc = new SparkContext(conf)

	val numbersRdd = sc.parallelize(List(1,2,3,4,5,6,7,8,9,10))
        val result = numbersRdd.reduce(_+_)
        println("Sum of 1 to 10 by using reduce() " + result)

        val sumAcc = sc.accumulator(0,"Sum")
        numbersRdd.foreach{ x=> sumAcc+= x}
               
	println("Sum Of 1 to 10 by using Accumulator " + sumAcc)

        val sumAggregate = numbersRdd.aggregate(0)(_+_, _+_)
        val sumAggregate5= numbersRdd.aggregate(5)(_+_, _+_)
        println("Sum Of 1 to 10 by using aggregate() " + sumAggregate)
        println("Sum Of 1 to 10 by using aggregate(5) " + sumAggregate5)
        
        sc.stop()
}
}
