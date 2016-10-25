package agoda.training.traits

trait Queue[T] {
  def put(item: T): Queue[T]
  def get(): T
  def isEmpty(): Boolean
  def isFull(): Boolean
}
