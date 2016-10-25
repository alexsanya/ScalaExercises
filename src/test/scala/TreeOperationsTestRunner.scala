import org.scalatest.FunSuite
import agoda.training.intTree._
import agoda.training.intTree.treeOperations._

class TreeOperationsTestRunner extends FunSuite {

  test("Should return false if item not in the tree") {
    val tree = Node(5, EmptyTree, EmptyTree)
    assert(!contains(tree, 7))
  }

  test("Should return true if item in the tree") {
    val tree = Node(7, EmptyTree, EmptyTree)
    assert(contains(tree, 7))
  }

  test("Should return true if item in the branch") {
    val tree = Node(5, EmptyTree, Node(7, EmptyTree, EmptyTree))
    assert(contains(tree, 7))
  }

  test("Should insert item in the tree") {
    val tree = Node(7, EmptyTree, EmptyTree)
    val tree5 = insert(tree, 5)
    assert(contains(tree5, 5))
    val tree59 = insert(tree5, 9)
    assert(contains(tree59, 9))
  }

}
