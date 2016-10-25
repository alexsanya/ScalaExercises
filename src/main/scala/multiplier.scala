package agoda.training.multiplier

object multiplier {

  def multiply(list: Array[Int], map: Map[Int, Int]): Array[Int] = {
    var result = List[Int]()
    for { item <- map.keys.filter(list.contains(_)) } {
      result = item * map(item) :: result
    }

    result.reverse.toArray
  }
}
