import org.junit.runner._
import org.specs2.runner._
import play.api.test._

@RunWith(classOf[JUnitRunner])
class ApplicationSpec extends PlaySpecification {

  "Application" should {

    "get greeting" in new WithApplication {
      val Some(greeting) = route(app, FakeRequest(GET, controllers.routes.Application.greeting().url))
      status(greeting) must equalTo(OK)
      contentAsString(greeting) must equalTo("Hello")
    }

    "get greetings must include arguments" in new WithApplication {
      val Some(greetings) = route(app, FakeRequest(GET, controllers.routes.Application.greetings("World").url))
      status(greetings) must equalTo(OK)
      contentAsString(greetings) must equalTo("Hello World")
    }

    "get greetings must include request parameter" in new WithApplication {
      val Some(greeting) = route(app, FakeRequest(GET, "/greetings?param=World"))
      status(greeting) must equalTo(OK)
      contentAsString(greeting) must equalTo("Hello World")
    }

    "render the index page" in new WithApplication {
      val home = route(app, FakeRequest(GET, controllers.routes.Application.index().url)).get
      status(home) must equalTo(OK)
      contentType(home) must beSome.which(_ == "text/html")
      contentAsString(home) must contain("Your new application is ready.")
    }
  }
}