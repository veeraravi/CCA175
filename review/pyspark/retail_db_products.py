from pyspark import SparkConf, SparkContext
conf = SparkConf().setMaster("local[2]").setAppName("retail_db_products.py")
sc = SparkContext(conf=conf)

def parsefile(rec):
        (pid,pcid,pname,pdesc,price,pimage) = rec.split(",")

productsFile = "/user/email2dgk/review/mysql/data/retail_db/products"

productsRdd = sc.textFile(productsFile)

productsParsedRdd = productsRdd.map(lambda line: parsefile)

productsCount = productsRdd.count()

print "There are %d products in %s " %(productsCount, productsFile)

print "sample 5 records from ProductsRdd are"

for rec in productsRdd.take(5):
        (pid,pcid,pname,pdesc,price,pimage) = rec.split(",")
        print "Product Name : %s and Price : %s " %(pname,price) 
productsPriceRdd = productsRdd.map(lambda rec: (rec.split(",")[0], 0.0 if rec.split(",")[4] == "" else float(rec.split(",")[4])))

costliestProduct = productsPriceRdd.sortBy(lambda (x,y): -y).take(1)

grouped = productsPriceRdd.groupByKey()
print "sample 5 Values"
for rec in grouped.take(5):
        print rec
		print costliestProduct
totalPrice = productsRdd.map(lambda rec: 0.0 if rec.split(",")[4] == "" else float(rec.split(",")[4])).reduce(lambda x,y: x+y)

print "Total Price of all the products"

print totalPrice

print "Price Only "

for rec in productsPriceRdd.take(10):
        print rec[0] , rec[1]

sc.stop()