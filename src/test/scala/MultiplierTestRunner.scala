import org.scalatest.FunSuite
import agoda.training.multiplier.multiplier._

class MultiplierTestRunner extends FunSuite {

  test("should multiply correctly") {
    assert(multiply(Array(1, 2, 3, 4), Map((1, 3), (3, 5))).toList == List(3, 15))
  }
}
