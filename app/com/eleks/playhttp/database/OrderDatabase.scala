package com.eleks.playhttp.database

import com.eleks.playhttp.core.BaseDatabase
import com.eleks.playhttp.models.Order
import javax.inject.Scope

@Scope
class OrderDatabase extends BaseDatabase[Order]{
  override var dbSet: Set[Order] = Data.orderDbSet
}
