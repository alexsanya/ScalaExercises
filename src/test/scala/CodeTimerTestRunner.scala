import org.scalatest.FunSuite
import agoda.training.timeit.codeTimer._

class CodeTimerTestRunner extends FunSuite {

  test("Should correctly measure block execution time") {
    timeit {
      Thread.sleep(500)
    }
  }

}
