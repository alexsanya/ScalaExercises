package agoda.training.timeit

object codeTimer {

  def timeit[R](block: => R): R = {
    val startPoint = System.nanoTime()
    val result = block
    val diffMks = (System.nanoTime() - startPoint) / 1000
    println(s"The execution of block took ${diffMks} micro-seconds")
    result
  }

}


