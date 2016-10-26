package agoda.training.lazyVector

class LazyVector(val vector: Seq[Int]) {
  lazy val x = this.calcX()
  lazy val y = this.calcY()
  lazy val z = this.calcZ()

  private def calcX()= {
    vector.map(p => p*p)
  }

  private def calcY(): Int = {
    x.sum
  }

  private def calcZ(): Double = {
    Math.sqrt(this.y)
  }
}
