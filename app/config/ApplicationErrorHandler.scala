package config

import play.api.http.{HttpErrorHandler, Status}
import play.api.libs.json.Json
import play.api.mvc.RequestHeader

import scala.concurrent.Future

@Singleton
class ApplicationErrorHandler extends HttpErrorHandler {
  override def onClientError(request: RequestHeader, statusCode: Int, message: String) =
    Future.successful(
      Status(statusCode)(
        Json.obj(
          "msg" -> "A client error occurred",
          "error" -> message
        )
      )
    )

  override def onServerError(request: RequestHeader, exception: Throwable) = {

    Future.successful(
      InternalServerError(
        Json.obj(
          "msg" -> "A server error occurred",
          "error" -> exception.getMessage
        )
      )
    )
  }
}