package com.eleks.playhttp.models

import com.eleks.playhttp.core.BaseEntity
import play.api.libs.json.Json

case class User(id: Long = 0, name: String, country: String) extends BaseEntity

object User {
  implicit val userFormat = Json.format[User]
}