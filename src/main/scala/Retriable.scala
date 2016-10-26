package agoda.training.retriable

object Retriable {

  case class RetryCount(count: Int)
  def retry[R](block: => Boolean)(implicit number: RetryCount): Unit = {
    var cnt = 0
    var success = false
    while (cnt < number.count && !success) {
      try {
        block
        success = true
      }
      catch {
        case _ : Throwable => cnt += 1
      }
      Thread.sleep(100)
    }
  }

}
