import agoda.training.lazyVector.LazyVector
import org.scalatest.FunSuite

class LzyVectorTestRunner extends FunSuite {

  test("Should calculate vectors") {
    val lv = new LazyVector(1, 2, 3)

    assert(lv.x == (1, 4, 9))
    assert(lv.y == 14)
    assert(lv.z > 3 && lv.z < 4)
  }

}
