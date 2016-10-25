package agoda.training.sets

trait IntSet {
  def incl(x: Int): IntSet
  def contains(x: Int): Boolean
  def union(s: IntSet): IntSet =
    new UnitedSet(this, s)
  def intersection(s: IntSet) =
    new IntersectedSet(this, s)
  def exclude(x: Int) =
    new ExcludedSet(x, this)
  def isEmpty(): Boolean
}

class EmptySet extends IntSet {
  def contains(x: Int): Boolean = false
  def isEmpty(): Boolean = true
  def incl(x: Int): IntSet = new NonEmptySet(x, new EmptySet, new EmptySet)
}

class NonEmptySet(elem: Int, left: IntSet, right: IntSet) extends IntSet {
  def contains(x: Int): Boolean =
    if (x < elem) left contains x
    else if (x > elem) right contains x
    else true
  def incl(x: Int): IntSet =
    if (x < elem) new NonEmptySet(elem, left incl x, right)
    else if (x > elem) new NonEmptySet(elem, left, right incl x)
    else this
  def isEmpty(): Boolean = false
}

class UnitedSet(left: IntSet, right: IntSet) extends IntSet {
  def contains(x: Int): Boolean =
    left.contains(x) || right.contains(x)
  def incl(x: Int): IntSet =
    new UnitedSet(left, right incl x)
  def isEmpty(): Boolean = false
}

class IntersectedSet(left: IntSet, right: IntSet) extends IntSet {
  def contains(x: Int): Boolean =
    left.contains(x) && right.contains(x)
  def incl(x: Int): IntSet =
    new UnitedSet(left incl x, right incl x)
  def isEmpty(): Boolean = false
}

class ExcludedSet(excl: Int, s: IntSet) extends IntSet {
  def contains(x: Int): Boolean =
    s.contains(x) && ( x != excl)
  def incl(x: Int): IntSet =
    s.incl(x)
  def isEmpty(): Boolean = false
}
