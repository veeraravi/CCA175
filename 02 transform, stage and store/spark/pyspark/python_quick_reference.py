# Defining a list of months
>>> months = ["jan","feb","mar","apr","may","jun","jul"]
#print a list
>>> print(months)
['jan', 'feb', 'mar', 'apr', 'may', 'jun', 'jul']
#print a list 2 nd element
>>> print(months[2])
mar
#print a list 1 to 3 elements
>>> print(months[1:3])
['feb', 'mar']
#print a list 4 times
>>> print(months * 4)
['jan', 'feb', 'mar', 'apr', 'may', 'jun', 'jul', 'jan', 'feb', 'mar', 'apr', 'may', 'jun', 'jul', 'jan', 'feb', 'mar', 'apr', 'may', 'jun', 'jul', 'jan', 'feb', 'mar', 'apr', 'may', 'jun', 'jul']
>>> months2 = ["aug","sep","oct","nov","dec"]
# concatenate two lists
>>> print(months + months2)
['jan', 'feb', 'mar', 'apr', 'may', 'jun', 'jul', 'aug', 'sep', 'oct', 'nov', 'dec']
>>> print(months + months2 * 2)
['jan', 'feb', 'mar', 'apr', 'may', 'jun', 'jul', 'aug', 'sep', 'oct', 'nov', 'dec', 'aug', 'sep', 'oct', 'nov', 'dec']
>>> print(months * 2 + months2 * 2)
['jan', 'feb', 'mar', 'apr', 'may', 'jun', 'jul', 'jan', 'feb', 'mar', 'apr', 'may', 'jun', 'jul', 'aug', 'sep', 'oct', 'nov', 'dec', 'aug', 'sep', 'oct', 'nov', 'dec']
>>> print(months * 2 + months2)
['jan', 'feb', 'mar', 'apr', 'may', 'jun', 'jul', 'jan', 'feb', 'mar', 'apr', 'may', 'jun', 'jul', 'aug', 'sep', 'oct', 'nov', 'dec']
>>> 
#Sum Of Two Numbers
#==================
>>> num1 = 10
>>> num2 = 20
>>> num3 = num1 + num2
>>> print "sum Of %i and %i = %i" %(num1,num2,num3)
sum Of 10 and 20 = 30
>>> print("sum Of %i and %i = %i" %(num1,num2,num3))
sum Of 10 and 20 = 30

#lambda 
#=========
sum = lambda a,b : a + b
diff = lambda a,b: a - b
strlen = lambda str: len(str)
>>> sum(100,50)
150
>>> diff(100,50)
50
>>> strlen("Python Spark - pyspark")
22
>>> strlen(5)
Traceback (most recent call last):
  File "<stdin>", line 1, in <module>
  File "<stdin>", line 1, in <lambda>
TypeError: object of type 'int' has no len()
>>> strlen("")
0
>>> strlen("   ")
3
>>> 

#Functions
  
>>> def sumOfAandB(a, b): 
...   return (a+b)
... 
>>> 
>>> sumOfAandB(10,50)
60
>>> sumOfAandB(0,0)
0
>>> sumOfAandB(0,1)
1

>>> def display(str):
...     print("Length Of String %s is %d " %(str, len(str)))
... 
>>> display("Python")
Length Of String Python is 6 
>>> 

