package agoda.training.almostEqual

object almostEqualOperation {
  implicit val precision = 0.1
  implicit final class ComparableDouble(val d: Double)(implicit precision: Double) {
    def ~=(other: Double) = Math.abs(d - other) <= precision
  }
}
