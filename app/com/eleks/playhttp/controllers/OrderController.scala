package com.eleks.playhttp.controllers

import com.eleks.playhttp.models.{Order, OrderResponse, Product}
import com.eleks.playhttp.services.{OrderService, ProductService, UserService}
import javax.inject.Inject
import play.api.libs.json.Json
import play.api.mvc.InjectedController

class OrderController @Inject()
  (orderService: OrderService, userService: UserService, productService: ProductService) extends InjectedController {

  implicit val orderFormat = Json.format[Order]
  implicit val productFormat = Json.format[Product]
  implicit val orderResponse = Json.format[OrderResponse]

  def getAllOrders = Action {
    Ok(Json.obj("Orders" -> orderService.getAllOrders.toList))
  }

  def getOrderById(id: Long) = Action {
    val productOpt: Option[Order] = orderService.getById(id)
    productOpt match {
      case Some(product) => Ok(Json.toJson(product))
      case None => NotFound(s"Product with id $id not found")
    }
  }

  def getOrdersById(id: Long) = Action {
    val orderOpt = orderService.getById(id)
    orderOpt match {
      case Some(order) => {
        val userOpt = userService.getUser(order.customerId)
        userOpt match {
          case Some(user) => {
            val products: List[Product] = productService.getRange(order.productIds)
            val orderTotal = products.map(_.price).sum
            Ok(Json.toJson(OrderResponse(id, user, products, orderTotal)))
          }
          case None => NotFound(s"User with id ${order.customerId} not found.")
        }
      }
      case None => NotFound(s"Order with id $id not found")
    }
  }
}
