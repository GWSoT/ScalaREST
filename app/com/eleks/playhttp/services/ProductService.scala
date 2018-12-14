package com.eleks.playhttp.services

import com.eleks.playhttp.database.{ProductDatabase, UserDatabase}
import com.eleks.playhttp.repository.{ProductRepository, UserRepository}
import javax.inject.{Inject, Scope}
import com.eleks.playhttp.models.Product


class ProductService @Inject() (dbContext: ProductDatabase) {
  val productRepository: ProductRepository = new ProductRepository(dbContext)
  def getAllProducts: Set[Product] = productRepository.getAll
  def getById(id: Long): Option[Product] = productRepository.getById(id)
  def getRange(ids: List[Long]): Set[Product] = ???
}
