package com.eleks.playhttp.models

import com.eleks.playhttp.core.BaseEntity

case class Order(id: Long = 0, customerId: Int, productIds: List[Int]) extends BaseEntity