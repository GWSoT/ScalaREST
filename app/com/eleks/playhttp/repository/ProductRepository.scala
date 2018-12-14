package com.eleks.playhttp.repository

import com.eleks.playhttp.core.{BaseDatabase, BaseRepository}
import com.eleks.playhttp.database.ProductDatabase
import com.eleks.playhttp.models.Product
import javax.inject.Scope

@Scope
class ProductRepository(databaseContext: ProductDatabase)
  extends BaseRepository[ProductDatabase, Product] (databaseContext)
