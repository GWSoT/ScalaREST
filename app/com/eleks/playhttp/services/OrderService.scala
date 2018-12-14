package com.eleks.playhttp.services

import com.eleks.playhttp.database.{OrderDatabase, ProductDatabase}
import com.eleks.playhttp.models.{Order, Product}
import com.eleks.playhttp.repository.{OrderRepository, ProductRepository}
import javax.inject.Inject

class OrderService @Inject() (orderDbContext: OrderDatabase, productDbContext: ProductDatabase){
  val orderRepository: OrderRepository = new OrderRepository(orderDbContext)
  val productRepository: ProductRepository = new ProductRepository(productDbContext)

  def getAllOrders: Set[Order] = orderRepository.getAll
  def getById(id: Long): Option[Order] = orderRepository.getById(id)
}
