class stu_basic(object):
	def __init__(self,sid,sname,sage,ssex):
		self.sid=sid
		self.sname=sname
		self.sage=sage	
		self.ssex=ssex

class stu_marks(object):
	def __init__(self,sid,subj1,subj2,subj3):
		self.sid=sid
		self.subj1=subj1
		self.subj2=subj2
		self.subj3=subj3

class stu_report(object):
	def __init__(self,sid,sname,subj1,subj2,subj3,total,avg):
		self.sid=sid
		self.sname=sname
		self.subj1=subj1
		self.subj2=subj2
		self.subj3=subj3
		self.total=total
		self.avg=avg
	def show_stu_report(self):
		print self.sid, "," ,self.sname,",", self.subj1,",",self.subj2,",",self.subj3,",",self.total,",",self.avg

	def getReport(self):
		return self.sid, self.sname,self.subj1,self.subj2,self.subj3,self.total,self.avg

