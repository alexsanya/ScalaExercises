import org.scalatest.FunSuite
import agoda.training.retriable.Retriable._

class RetriableTestRunner extends FunSuite {
  implicit val number = 3
  var cnt = 0
  test("should repeat function") {
    retry {
      cnt += 1
      false
    }
    assert(cnt == number)
  }


}
