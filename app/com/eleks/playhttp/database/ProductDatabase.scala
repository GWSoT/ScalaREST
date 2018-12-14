package com.eleks.playhttp.database

import com.eleks.playhttp.core.BaseDatabase
import com.eleks.playhttp.models.Product
import javax.inject.Scope

@Scope
class ProductDatabase extends BaseDatabase[Product] {
  override var dbSet: Set[Product] = Data.productDbSet
}
