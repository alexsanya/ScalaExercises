package agoda.training.timeit

object codeTimer {

  def timeitInternal[R](block: => R): (R, Long) = {
    val startPoint = System.nanoTime()
    val result = block
    val diffMks = (System.nanoTime() - startPoint) / 1000
    println(s"The execution of block took ${diffMks} micro-seconds")
    result -> diffMks
  }

  def timeit[R](block: => R) : R = timeitInternal(block)._1

}


