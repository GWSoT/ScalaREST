package com.eleks.playhttp.repository

import com.eleks.playhttp.core.BaseRepository
import com.eleks.playhttp.database.{OrderDatabase, ProductDatabase}
import com.eleks.playhttp.models.{Order, OrderResponse, Product}

class OrderRepository(databaseContext: OrderDatabase)
  extends BaseRepository[OrderDatabase, Order] (databaseContext) {

  def getOrdersByCustomerId(customerId: Long): Set[Order] = db.filter(_.customerId == customerId)
}