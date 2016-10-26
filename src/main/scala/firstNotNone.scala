package agoda.training.firstNotNone

object firstNotNone {
  def getSome[T](x: Option[T], y: Option[T], z: Option[T]): Option[T] = x orElse y orElse z
}
