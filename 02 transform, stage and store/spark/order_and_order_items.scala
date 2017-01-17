case class orders(order_id:Int, order_date:String, order_customer_id:Int, order_status:String)
case class order_items(order_item_id:Int, order_item_order_id:Int, order_item_product_id:Int, order_item_quantity:Int,
order_item_subtotal:Double, order_item_product_price:Double) 

val orderItemsFile = "/user/email2dgk/review/mysql/data/retail_db/order_items"
val orderItemsRdd = sc.textFile(orderItemsFile).map(_.split(","))

val orderItemsRDD = orderItemsRdd.map(x=> new order_items(x(0).toInt,x(1).toInt,x(2).toInt,x(3).toInt,
x(4).toDouble,x(5).toDouble))

val totalPerOrderId = orderItemsRdd.map(x=> (x(1).toInt, x(4).toDouble)).reduceByKey(_+_)

val ordersFile = "/user/email2dgk/review/mysql/data/retail_db/orders"
val orderRdd= sc.textFile(ordersFile).map(_.split(","))
val ordersRDD = orderRddmap(x=> new orders(x(0).toInt,x(1),x(2).toInt, x(3).toInt))

val orderItemsKvRdd = orderItemsRDD.map(x=> (x.order_item_order_id, x))
val ordersKvRdd = ordersRDD.map(x=> (x.order_id, x))

val joinedRdd = ordersKvRdd.leftOuterJoin(orderItemsKvRdd)