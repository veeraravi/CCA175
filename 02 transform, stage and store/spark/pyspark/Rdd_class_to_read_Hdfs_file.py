from pyspark import SparkContext, SparkConf

conf = SparkConf().setAppName("Rdd_class_to_read_Hdfs_file.py").setMaster("local[2]")
sc  = SparkContext(conf=conf)

inputFile = "/user/cloudera/cca175/spark/input/student_basic.txt"

#Student class
class student:
	def __init__(self,sid,sname,sage,ssex)	:
		self.sid=sid
		self.sname=sname
		self.sage=sage
		self.ssex=ssex
	def showData(self):
		print "ID ", self.sid ," Name " , self.sname
	
inputRdd = sc.textFile(inputFile).map(lambda data: student(data.split(",")[0],data.split(",")[1],data.split(",")[2],data.split(",")[3]))

# To display student fields
def showStudent(rec):
	print rec.sid, rec.sname, rec.sage, rec.ssex

# display student_basic RDD by using foreach()
print("Display student_basic RDD by using foreach()")
inputRdd.foreach(showStudent)

# Invoke showData() of the class Student

inputRdd.foreach(lambda x: x.showData())
sc.stop()



