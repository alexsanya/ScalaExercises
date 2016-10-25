package agoda.training.median

object medianMethod {

  implicit final class MedianSeq(val s: Seq[Int]) {
    def median: Float = {
      val sorted = s.sortWith((a: Int, b: Int) => a > b)
      (sorted.last - sorted.reverse.last) / 2
    }
  }
}
