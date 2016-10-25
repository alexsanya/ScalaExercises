import org.scalatest.FunSuite
import agoda.training.firstNotNone.firstNotNone._

class FirstNonNoneTestRunner extends FunSuite {

  test("Should return first non-null item") {
    assert(getSome[Int](None, None, Some(1)) == Some(1))
    assert(getSome[Int](None, Some(2), Some(1)) == Some(2))
    assert(getSome[Int](Some(3), Some(2), Some(1)) == Some(3))
  }
}
