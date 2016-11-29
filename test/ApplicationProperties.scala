import org.scalacheck.Gen
import org.scalacheck.Gen.choose
import org.scalatest.PropSpec
import org.scalatest.prop.PropertyChecks

class ApplicationProperties extends PropSpec with PropertyChecks {

  def sum(addends: Int*): Int = addends.sum

  val x: Gen[Int] = choose(0, Int.MaxValue)

  property("startsWith") {
    forAll { (a: String, b: String) =>
      (a + b).startsWith(a)
    }
  }

  property("concatenate") {
    forAll { (a: String, b: String) =>
      (a + b).length > a.length && (a + b).length > b.length
    }
  }

  property("substring") {
    forAll { (a: String, b: String, c: String) =>
      (a + b + c).substring(a.length, a.length + b.length) == b
    }
  }
}