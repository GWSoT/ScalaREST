package com.eleks.playhttp.database

import com.eleks.playhttp.models.{Order, Product, User}

object Data {
  val userDbSet: Set[User] = Set(
    User(1, "Tommy", "NY"),
    User(2, "John", "LA"),
    User(3, "Nick", "NY"),
    User(4, "Rob", "Detroit"),
    User(5, "Alice", "Boston"),
    User(6, "Alan", "LA")
  )

  var productDbSet: Set[Product] = Set(
    Product(1, "Nokia 3110", 125),
    Product(2, "LG A75", 75),
    Product(3, "Lenovo Tab 3", 350),
    Product(4, "IPhone X", 270),
    Product(5, "Xiaomi ReadMe 4", 65),
    Product(6, "IPhone 6", 150)
  )

  var orderDbSet: Set[Order] = Set(
    Order(1, 1, List(1,2,2)),
    Order(2, 2, List(4)),
    Order(3, 3, List(3,3,3)),
    Order(4, 2, List(1,5)),
    Order(5, 1, List(2,4)),
    Order(6, 1, List(1,1,4,4,5))
  )

}
