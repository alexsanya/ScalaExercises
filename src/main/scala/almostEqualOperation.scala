package agoda.training.almostEqual

object almostEqualOperation {
  case class EqualEpsilon(epsilon: Double)

  implicit val precision = EqualEpsilon(0.1)
  implicit final class ComparableDouble(val d: Double)(implicit precision: EqualEpsilon) {
    def ~=(other: Double) = Math.abs(d - other) <= precision.epsilon
  }
}
