package agoda.training.lazyVector

class LazyVector(val vector: (Int, Int, Int)) {
  lazy val x = this.calcX()
  lazy val y = this.calcY()
  lazy val z = this.calcZ()

  private def calcX(): (Int, Int, Int) = {
    (this.vector._1 * this.vector._1, this.vector._2 * this.vector._2, this.vector._3 * this.vector._3)
  }

  private def calcY(): Int = {
    this.x._1 + this.x._2 + this.x._3
  }

  private def calcZ(): Double = {
    Math.sqrt(this.y)
  }
}
