package com.eleks.playhttp.services

import com.eleks.playhttp.core.BaseRepository
import com.eleks.playhttp.database.UserDatabase
import com.eleks.playhttp.models.User
import com.eleks.playhttp.repository.UserRepository
import javax.inject.{Inject, Singleton}

class UserService @Inject() (dbContext: UserDatabase) {
  val userRepository: UserRepository = new UserRepository(dbContext)
  def saveUser(row: User) = userRepository.save(row)

  def getUser(id: Long) = userRepository.getById(id)
}
