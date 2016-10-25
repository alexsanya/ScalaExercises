import org.scalatest.FunSuite
import org.scalatest.BeforeAndAfter
import agoda.training.squareList.squareListOperation._

class SquareListTestRunner extends FunSuite with BeforeAndAfter {

  var list: List[Int] = _
  val squaredList = List(1, 4, 9)

  before {
    list = List(1, 2, 3)
  }

  test("First version should work correctly") {
    assert(squareList1(list) == squaredList)
  }

  test("Second version should work correctly") {
    assert(squareList2(list) == squaredList)
  }
}
