package agoda.training.intTree

abstract class IntTree
case object EmptyTree extends IntTree
case class Node(elem: Int, left: IntTree, right: IntTree) extends IntTree

object treeOperations {
  def contains(t: IntTree, v: Int): Boolean = t match {
      case EmptyTree => false
      case n: Node => n.elem == v || contains(n.left, v) || contains(n.right, v)
  }
  def insert(t: IntTree, v: Int): IntTree = t match {
      case EmptyTree => Node(v, EmptyTree, EmptyTree)
      case n: Node =>
        if (v <= n.elem) Node(n.elem, insert(n.left, v), n.right)
        else Node(n.elem, n.left, insert(n.right, v))

  }
}