import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf

object Demo1 {
  def main(args: Array[String]) {
    
    val conf = new SparkConf().setAppName("Simple Application")
    val sc = new SparkContext(conf)
	
	val logFile = "/user/cloudera/cca175/spark/data/input/student_basic.txt"	
	
    val logData = sc.textFile(logFile, 2).cache()
	
	val total = logData.flatMap(_.split(",")).map(x=> 1).reduce( (a,b) => (a+b))
  
    println("Total no.of words in the given file is " + total)
    
  }
}