package agoda.training.squareList

object squareListOperation {
  def squareList1(xs: List[Int]): List[Int] = xs match {
    case List() => List()
    case y :: ys => (y*y) :: squareList1(ys)
  }

  def squareList2(xs: List[Int]): List[Int] =
    xs map ((x: Int) => x*x)

}
