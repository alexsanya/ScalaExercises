package agoda.training.traits

trait Reversable extends Queue[String] {
  abstract override def put(item: String): Queue[String] = {
    super.put(item.reverse)
  }
}
