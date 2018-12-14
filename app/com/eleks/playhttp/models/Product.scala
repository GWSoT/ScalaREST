package com.eleks.playhttp.models

import com.eleks.playhttp.core.BaseEntity
import play.api.libs.json.Json

case class Product(id: Long = 0, name: String, price: Double) extends BaseEntity

//object Product {
//  implicit val productFormat = Json.format[Product]
//}