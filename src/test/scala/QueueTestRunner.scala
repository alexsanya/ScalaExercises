import org.scalatest.FunSuite
import org.scalatest.BeforeAndAfter
import agoda.training.traits._

class QueueTestRunner extends FunSuite with BeforeAndAfter {

  var queue: Queue[String] = _

  before {
    queue = new ArrayStringQueue()
  }

  test("Should be empty at the beginning") {
    assert(queue.isEmpty() == true)
  }

  test("Should not be empty when contain items") {
    queue put "something"
    assert(queue.isEmpty() == false)
  }

  test("Should be empty after all items retrieved") {
    queue put "something"
    queue get()
    assert(queue.isEmpty() == true)
  }

  test("Should not be full when contains 100 items") {
    for (_ <- 1 to 100)
      queue put "something"
    assert(queue.isFull() == true)
  }

  test("Should extract items in correct order") {
    queue put "first"
    queue put "second"
    queue put "third"
    assert(queue.get() == Some("first"))
    assert(queue.get() == Some("second"))
    assert(queue.get() == Some("third"))
  }

  test("Should reverse input items") {
    val reversableQueue = new ArrayStringQueue() with Reversable

    reversableQueue put "abc"
    assert(reversableQueue.get() == Some("cba"))
  }
}

