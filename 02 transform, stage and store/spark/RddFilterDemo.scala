import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf

object RddFilterDemo{


def main(args: Array[String]){

    val conf = new SparkConf().setAppName("RddFilterDemo")
	val sc = new SparkContext(conf)

	case class basic(sid:Int, sname:String, sage:Int, ssex:String){
	override def toString = s"$sid,$sname,$sage,$ssex"
	}
	case class address(sid:Int, scity:String, szip:Int, sstate:String){
	override def toString = s"$sid,$scity,$szip,$sstate"
	}
	
	val basicRdd ={ sc.textFile("/user/cloudera/cca175/spark/data/input/student_basic.txt").
                 map{x=> val y = x.split(","); new basic(y(0).toInt, y(1),y(2).toInt, y(3))}} 
				 
	val addressRdd = {sc.textFile("/user/cloudera/cca175/spark/data/input/student_address.txt").
                 map{x=> val y = x.split(","); new address(y(0).toInt, y(1),y(2).toInt, y(3))}}

	
	val maleRdd = basicRdd.filter(_.ssex == "Male")
	val femaleRdd = basicRdd.filter(_.ssex == "Female")
	
	maleRdd.saveAsTextFile("/user/cloudera/cca175/spark/data/output/maleStudents")
	femaleRdd.saveAsTextFile("/user/cloudera/cca175/spark/data/output/femaleStudents")
	
	println("Total No.of Male Students = " + maleRdd.count())
	println("Total No.of Female Students = " + femaleRdd.count())
	
}

}