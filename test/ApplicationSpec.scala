import org.scalatestplus.play.PlaySpec
import org.scalatestplus.play.guice.GuiceOneServerPerSuite
import play.api.test.Helpers._
import play.api.test._

class ApplicationSpec extends PlaySpec with GuiceOneServerPerSuite {

  "Application" must {

    "get greeting" in {
      val Some(greeting) = route(app, FakeRequest(GET, controllers.routes.Application.greeting().url))
      status(greeting) mustBe OK
      contentAsString(greeting) mustBe "Hello"
    }

    "get greetings must include arguments" in {
      val Some(greetings) = route(app, FakeRequest(GET, controllers.routes.Application.greetings("World").url))
      status(greetings) mustBe OK
      contentAsString(greetings) mustBe "Hello World"
    }

    "get greetings must include request parameter" in {
      val Some(greeting) = route(app, FakeRequest(GET, "/greetings?param=World"))
      status(greeting) mustBe OK
      contentAsString(greeting) mustBe "Hello World"
    }

    "render the index page" in {
      val home = route(app, FakeRequest(GET, controllers.routes.Application.index().url)).get
      status(home) mustBe OK
      contentType(home) mustBe Some("text/html")
      contentAsString(home) must include("Your new application is ready.")
    }

    "render the visit page with no parameter set" in {
      val visit = route(app, FakeRequest(GET, "/visit")).get
      status(visit) mustBe OK
      contentType(visit) mustBe  Some("text/html")
      contentAsString(visit) must include("random user")
    }

    "render the visit page with option visitor parameter" in {
      val visit = route(app, FakeRequest(GET, "/visit?visitor=Bob")).get
      status(visit) mustBe OK
      contentType(visit) mustBe Some("text/html")
      contentAsString(visit) must include("Bob")
    }
  }
}
