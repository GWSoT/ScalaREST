package com.eleks.playhttp.core

import java.util.concurrent.locks.{Lock, ReentrantLock}

trait BaseDatabase[T <: BaseEntity] {
  var dbSet: Set[T]
  private[this] val lock :Lock = new ReentrantLock()

   def save(row: T): Option[T] = {
    try {
      lock.lock()
      val sizeBefore = dbSet.size
      dbSet += row
      val sizeAfter = dbSet.size

      if (sizeBefore == sizeAfter) None
      else Some(row)
    }
    catch {
      case e: Throwable => throw e;
    }
    finally {
      lock.unlock()
    }
  }

  def filter(expr: T => Boolean): Set[T] = dbSet.filter(expr)

  def getById(id: Long): Option[T] = dbSet.find(_.id == id)

  def getAll: Set[T] = dbSet

  def delete(row: T): Boolean = {
    try {
      lock.lock()
      val sizeBefore = dbSet.size
      dbSet -= row
      val sizeAfter = dbSet.size

      if (sizeBefore == sizeAfter) false
      else true
    }
    catch {
      case e: Throwable => throw e
    }
    finally {
      lock.unlock()
    }
  }

   def update(oldUser: T, newUser: T): Option[T] = {
    try {
      lock.lock()
      val sizeBefore = dbSet.size
      dbSet -= oldUser
      dbSet += newUser
      val sizeAfter = dbSet.size

      if (sizeBefore == sizeAfter) Some(newUser)
      else None
    }
    catch {
      case e: Throwable => throw e
    }
    finally {
      lock.unlock()
    }
  }
}
