package agoda.training.retriable

object Retriable {

  def retry[R](block: => Boolean)(implicit number: Int): Unit = {
    var cnt = 0;
    var success = false;
    while (cnt < number && !success) {
      success = block
      cnt += 1
      Thread.sleep(100)
    }
  }

}
