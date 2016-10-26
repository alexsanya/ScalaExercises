import agoda.training.lazyVector.LazyVector
import org.scalatest.FunSuite

class LzyVectorTestRunner extends FunSuite {

  test("Should calculate vectors") {
    val lv = new LazyVector(Seq(1, 2, 3))

    assert(lv.x == List(1, 4, 9))
    assert(lv.y == 14)
    assert(lv.z > 3 && lv.z < 4)
  }

}
