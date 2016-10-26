import org.scalatest.FunSuite
import agoda.training.timeit.codeTimer._

class CodeTimerTestRunner extends FunSuite {

  test("Should correctly measure block execution time") {
    val DURATION_MS = 500
    val DELTA_MS = 50
    val (output, time) = timeitInternal {
      Thread.sleep(DURATION_MS)
    }


    assert(Math.abs(time / 1e3 - DURATION_MS) < DELTA_MS)
  }

}
