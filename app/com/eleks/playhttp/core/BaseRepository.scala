package com.eleks.playhttp.core

import scala.reflect.ClassTag

abstract class BaseRepository[E <: BaseDatabase[T], T <: BaseEntity : ClassTag](database: E) {

  val db: E = database

  def getById(id: Long): Option[T] = {
    db.getById(id)
  }
  def deleteById(row: T): Boolean = db.delete(row)
  def save(row: T): Option[T] = db.save(row)
  def getAll: Set[T] = db.getAll
  def updateById(oldRow: T, newRow: T): Option[T] = db.update(oldRow, newRow)
}
