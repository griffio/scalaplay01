import org.specs2.mutable._
import org.specs2.runner._
import org.junit.runner._
import play.api.mvc.Results
import play.api.test._
import play.api.test.Helpers._

@RunWith(classOf[JUnitRunner])
class ApplicationSpec extends PlaySpecification  {

  "Application" should {

    "get greeting" in new WithApplication {
      val Some(greeting) = route(app, FakeRequest(GET, controllers.routes.Application.greeting().url))
      status(greeting) must equalTo(OK)
      contentAsString(greeting) must equalTo("Hello world")
    }

    "get greeting must include request parameter" in new WithApplication {
      val Some(greeting) = route(app, FakeRequest(GET, "/greeting2?param=world"))
      status(greeting) must equalTo(OK)
      contentAsString(greeting) must equalTo("Hello world")
    }

    "render the index page" in new WithApplication {
      val home = route(app, FakeRequest(GET, controllers.routes.Application.index().url)).get
      status(home) must equalTo(OK)
      contentType(home) must beSome.which(_ == "text/html")
      contentAsString(home) must contain ("Your new application is ready.")
    }
  }
}
