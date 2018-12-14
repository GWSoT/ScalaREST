package com.eleks.playhttp.models

import com.eleks.playhttp.core.BaseEntity

case class OrderResponse(id: Long = 0, customer: User, products: List[Product], totalPrice: Double)
  extends BaseEntity
