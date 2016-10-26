import org.scalatest.FunSuite
import agoda.training.almostEqual.almostEqualOperation._

class AlmostEqualOperationTestRunner extends FunSuite {

  test("Should be equal if delta is less than precision") {
    assert((1.1 ~= 1.15) == true)
  }

  test("Should not be equal if delta is greater than precision") {
    assert((1.1 ~= 1.3) == false)
  }

  test("Should support custom precision") {
    implicit val precision = EqualEpsilon(0.5)
    assert((1.1 ~= 1.3) == true)
  }
}
