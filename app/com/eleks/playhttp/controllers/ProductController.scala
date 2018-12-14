package com.eleks.playhttp.controllers

import com.eleks.playhttp.services.ProductService
import javax.inject.Inject
import play.api.libs.json._
import play.api.mvc.{Action, InjectedController}
import com.eleks.playhttp.models.Product

class ProductController @Inject() (productService: ProductService) extends InjectedController {

  implicit val productFormat = Json.format[Product]

  def getAllProducts = Action {
    Ok(Json.obj("products" -> productService.getAllProducts.toList))
  }

  def getProductById(id: Long) = Action {
    val productOpt: Option[Product] = productService.getById(id)
    productOpt match {
      case Some(product) => Ok(Json.toJson(product))
      case None => NotFound(s"Order with id $id not found")
    }
  }
}
