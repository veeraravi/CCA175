import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf

object SimpleWordCountDemo {

 def main(args: Array[String]){
 
    val conf = new SparkConf().setAppName("SimpleWordCountDemo")
	val sc = new SparkContext(conf)
 
    val inputRdd = sc.textFile("hdfs://quickstart.cloudera:8020/user/cloudera/cca175/spark/data/input/student_basic.txt")

	val wordRdd = inputRdd.flatMap(_.split(",")).map(x=> (x,1)).reduceByKey(_ + _)

	wordRdd.saveAsTextFile("hdfs://quickstart.cloudera:8020/user/cloudera/cca175/spark/data/output/student_basic_wordCount")
 
 }

}