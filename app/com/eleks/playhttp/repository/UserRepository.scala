package com.eleks.playhttp.repository

import com.eleks.playhttp.core.BaseRepository
import com.eleks.playhttp.database.UserDatabase
import com.eleks.playhttp.models.User
import javax.inject.Scope

@Scope
class UserRepository(databaseContext: UserDatabase)
  extends BaseRepository[UserDatabase, User](databaseContext)
