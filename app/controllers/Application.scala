package controllers

import play.api.mvc._

class Application extends Controller {

  def greeting = Action {
    Ok("Hello")
  }

  def greetings(name: String) = Action {
    Ok(s"Hello $name")
  }

  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }
}