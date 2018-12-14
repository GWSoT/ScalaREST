package com.eleks.playhttp.database

import java.util.concurrent.locks.{Lock, ReentrantLock}

import com.eleks.playhttp.core.BaseDatabase
import com.eleks.playhttp.models.User
import javax.inject.Scope

@Scope
class UserDatabase extends BaseDatabase[User]{
  override var dbSet: Set[User] = Data.userDbSet
}
