import org.scalatest.FunSuite
import agoda.training.GCD.greatCommonDivisor._

class GreatCommonDivisorTestRunner extends FunSuite {

  test("Should calculate GCD correctly") {
    assert(countGCD (1, 462) == 1)
    assert(countGCD (7, 21) == 7)
    assert(countGCD (1071, 462) == 21)
  }
}
