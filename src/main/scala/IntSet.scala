package agoda.training.sets

trait IntSet {
  def incl(x: Int): IntSet
  def isEmpty(): Boolean
  def contains(x: Int): Boolean
  def exclude(x: Int): IntSet
  def union(x: IntSet): IntSet
  def intersection(x: IntSet): IntSet
}

class EmptySet extends IntSet {
  def contains(x: Int): Boolean = false
  def isEmpty(): Boolean = true
  def incl(x: Int): IntSet = new NonEmptySet(x, new EmptySet, new EmptySet)
  def union(x: IntSet) = x
  def exclude(x: Int): IntSet = this
  def intersection(x: IntSet): IntSet = new EmptySet
}

class NonEmptySet(elem: Int, left: IntSet, right: IntSet) extends IntSet {
  def isEmpty(): Boolean = false
  def contains(x: Int): Boolean =
    if (x < elem) left contains x
    else if (x > elem) right contains x
    else true
  def incl(x: Int): IntSet =
    if (x < elem) new NonEmptySet(elem, left incl x, right)
    else if (x > elem) new NonEmptySet(elem, left, right incl x)
    else this
  def exclude(x: Int): IntSet =
    if (x == elem) this.left.union(this.right)
    else this.left.exclude(x).union(this.right.exclude(x))
  def union(x: IntSet): IntSet = x match {
    case _: EmptySet => this
    case s: NonEmptySet => s.incl(this.elem).union(this.left).union(this.right)
  }
  def intersection(x: IntSet): IntSet = x match {
    case _: EmptySet => new EmptySet
    case s: NonEmptySet =>
      if (s.contains(this.elem)) new NonEmptySet(this.elem, new EmptySet, new EmptySet).union(this.exclude(this.elem).intersection(s.exclude(this.elem)))
      else this.exclude(this.elem).intersection(s)
  }
}

