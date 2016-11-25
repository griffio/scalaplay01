package controllers

import play.api.mvc._

class Application extends Controller {

  def greeting = Action {
    Ok("Hello world")
  }

  def greeting2(name: String) = Action {
    Ok("Hello " + name)
  }

  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }

}