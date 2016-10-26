import agoda.training.median.medianMethod._
import org.scalatest.FunSuite

class MedianMethodTestRunner extends FunSuite {

  test("Should work with integer") {
    assert(Seq(1, 2, 3, 4, 5).median  == 2)
  }

  test("Should work with doubles") {
    assert(Seq(1.0, 3.0).median == 1.0)
  }
}
