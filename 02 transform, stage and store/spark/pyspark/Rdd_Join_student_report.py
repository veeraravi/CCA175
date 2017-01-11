from student_classes import stu_basic, stu_marks, stu_report
from pyspark import SparkContext, SparkConf

conf = SparkConf().setAppName("Rdd_Join_student_report.py").setMaster("local[2]")
sc = SparkContext(conf=conf)

logger = sc._jvm.org.apache.log4j
logger.LogManager.getLogger("org"). setLevel( logger.Level.ERROR )
logger.LogManager.getLogger("akka").setLevel( logger.Level.ERROR )


basicFile = "/user/cloudera/cca175/spark/input/student_basic.txt"
marksFile = "/user/cloudera/cca175/spark/input/student_marks.txt"
reportFile = "/user/cloudera/cca175/spark/output/student_reports_pyspark"

def parseBasic(rec):
	fid,fname,fage,fsex = rec.split(",")
	return (fid, stu_basic(fid,fname,fage,fsex))
	
def parseMarks(rec):
	fid,fsubj1,fsubj2,fsubj3 = rec.split(",")
	return (fid, stu_marks(fid,fsubj1,fsubj2,fsubj3))

def createReport(rec):
	sid,joined = rec
	v1,v2 = joined
	sname = v1.sname
	subj1 = v2.subj1
	subj2 = v2.subj2
	subj3 = v2.subj2
	total = int(subj1) + int(subj2) + int(subj3)
	avg = total/3
	return stu_report(sid,sname,subj1,subj2,subj3,total,avg)

def show(rec):
	print rec

def report(rec):
	rec.show_stu_report()
	
def showreport(rec):
	print "SID" , rec.sid, "SName:" , rec.sname

	
basicRdd = sc.textFile(basicFile).map(parseBasic)
marksRdd = sc.textFile(marksFile).map(parseMarks)

joinedRdd = basicRdd.join(marksRdd)
reportRdd = joinedRdd.map(createReport)
reportRdd.map(lambda s: s.getReport()).saveAsTextFile(reportFile)

for x in reportRdd.take(5):
	showreport(x)

for x in reportRdd.take(5):
	report(x)

for x in joinedRdd.take(5):
	show(x)
	
sc.stop()

