import org.scalatest.FunSuite
import agoda.training.sets._

class IntSetTestRunner extends FunSuite {

  test("Should correctly unite empty and non-empty sets") {
    val setA = new EmptySet()
    val setB = new NonEmptySet(5, new EmptySet(), new EmptySet())
    assert(setA.union(setB).contains(5))
    assert(setB.union(setA).contains(5))
  }

  test("Should correctly unite 2 non-empty sets") {
    val setA = new NonEmptySet(5, new EmptySet(), new EmptySet())
    val setB = new NonEmptySet(7, new EmptySet(), new EmptySet())
    assert(setA.union(setB).contains(5))
    assert(setB.union(setA).contains(5))
    assert(setA.union(setB).contains(7))
    assert(setB.union(setA).contains(7))
  }

  test("Should correctly intersect empty and non-empty sets") {
    val setA = new EmptySet()
    val setB = new NonEmptySet(5, new EmptySet(), new EmptySet())
    assert(!setA.intersection(setB).contains(5))
    assert(!setB.intersection(setA).contains(5))
  }

  test("Should correctly intersect 2 non-empty sets") {
    val setA = new NonEmptySet(5, new EmptySet(), new NonEmptySet(7, new EmptySet(), new EmptySet()))
    val setB = new NonEmptySet(7, new EmptySet(), new EmptySet())
    assert(!setA.intersection(setB).contains(5))
    assert(!setB.intersection(setA).contains(5))
    assert(setA.intersection(setB).contains(7))
    assert(setB.intersection(setA).contains(7))
  }

  test("should exclude item from set") {
    val setA = new NonEmptySet(5, new EmptySet(), new NonEmptySet(7, new EmptySet(), new EmptySet()))
    assert(!setA.exclude(7).contains(7))
  }
}
