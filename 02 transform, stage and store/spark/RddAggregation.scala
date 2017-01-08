import org.apache.spark.SparkContext
import org.apache.spark.SparkConf

object RddAggregation {


def main(args: Array[String]){

   val conf = new SparkConf().setAppName("RddAggregation")
   val sc = new SparkContext(conf)

   case class marks(sid:Int, subj1:Int, subj2:Int, subj3:Int)
   case class report(sid:Int, total:Int, avg:Double)

   val inputRdd = sc.textFile("/user/cloudera/cca175/spark/data/input/student_marks.txt").map{
   x=> 
   val y = x.split(",")
   new marks(y(0).toInt,y(1).toInt,y(2).toInt,y(3).toInt) }
   
   inputRdd.foreach{
   case(stu) =>
   println("sid = " + stu.sid + "subj1 = " + stu.subj1 + "subj2 = " + stu.subj2 +  "subj3 = " + stu.subj3)  
   }
   
   inputRdd.foreach{
   case(stu) => 
       val total = stu.subj1 + stu.subj2 + stu.subj3
	   val avg = total / 3
	   println("SID = " + stu.sid + " Total = " + total + " Average = " + avg)
   }


}



}