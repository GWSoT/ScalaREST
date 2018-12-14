package com.eleks.playhttp.controllers

import com.eleks.playhttp.models.User
import com.eleks.playhttp.services.UserService
import javax.inject.Inject
import play.api.libs.json.{JsValue, Json}
import play.api.mvc.{InjectedController, _}

class Controller @Inject() (userService: UserService) extends InjectedController {

  implicit val userFormat = Json.format[User]

  def getUser(id: Long) = Action {
    val userOpt: Option[User] = userService.getUser(id)
    userOpt match {
      case Some(user) => Ok(Json.toJson(user))
      case None => NotFound(s"User with id = $id does not exist")
    }
  }

  def saveUser: Action[JsValue] = Action(parse.json) { request =>
    val user = request.body.as[User]
    val userOpt = userService.saveUser(user)
    userOpt match {
      case Some(_) => Created("User was created.")
      case None => NotAcceptable("User already exists")
    }
  }
}
