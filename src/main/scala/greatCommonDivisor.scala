package agoda.training.GCD

object greatCommonDivisor {
  import scala.annotation.tailrec

  @tailrec
  def countGCD(pair: (Int, Int)): Integer = {
    val diff = Math.abs(pair._1 - pair._2)
    pair match {
      case (_, 0) | (0, _) => pair._1 + pair._2
      case unexpected => countGCD (diff, (pair._1 + pair._2 - diff) / 2)
    }
  }
}
