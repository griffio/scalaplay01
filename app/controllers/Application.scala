package controllers

import javax.inject.Inject

import play.api.mvc._

class Application @Inject() (val cc: ControllerComponents,
                             implicit val assetsFinder: AssetsFinder) extends AbstractController(cc) {

  def greeting = Action {
    Ok("Hello")
  }

  def greetings(name: String) = Action {
    Ok(s"Hello $name")
  }

  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }

  def visit(visitor: Option[String]) = Action {
    val value = visitor.getOrElse("random user")
    Ok {
      s"""
         |<!DOCTYPE html>
         |<html>
         |  <head>
         |    <title>Visitor Page</title>
         |  </head>
         |  <body>
         |    <h1>Greetings, $value</h1>
         |  </body>
         |</html>
      """.stripMargin
    }.as("text/html")
  }

}
