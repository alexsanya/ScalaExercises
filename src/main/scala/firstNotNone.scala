package agoda.training.firstNotNone

object firstNotNone {
  def getSome[T](x: Option[T], y: Option[T], z: Option[T]): Option[T] = {
    List(x, y, z).reduce((accum: Option[T], x: Option[T]) => {
      accum match {
        case None => x
        case _: Option[T] => accum
      }
    })
  }
}
