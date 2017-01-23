val sqlsc = new org.apache.spark.sql.SQLContext(sc)
import sqlsc.createSchemaRDD
case class departments(depId:Int, depName:String)

val departmentsFile = "/user/cloudera/cca175/retail_db/departments"
val departmentsRdd = sc.textFile(departmentsFile).map{x=> val z=x.split(","); new departments(z(0).toInt, z(1))}
departmentsRdd.registerTempTable("department")

val departmentNames = sqlsc.sql("select depName from departments")

departmentNames.count()
