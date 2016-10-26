package agoda.training.median

object medianMethod {
  // Use Numeric
  implicit final class MedianSeq[T](val s: Seq[T])(implicit numeric: Numeric[T]) {
    def median: Double = {
      val sorted = s.sorted
      numeric.toDouble(numeric.minus(sorted.last, sorted.reverse.last) )/ 2
    }
  }
}
