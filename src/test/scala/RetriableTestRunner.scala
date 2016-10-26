import org.scalatest.FunSuite
import agoda.training.retriable.Retriable._

class RetriableTestRunner extends FunSuite {
  implicit val number = RetryCount(3)
  var cnt = 0
  test("should repeat function") {
    retry {
      cnt += 1
      throw new Exception
    }
    assert(cnt == number.count)
  }
}
