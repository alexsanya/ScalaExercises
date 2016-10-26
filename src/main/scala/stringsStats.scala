package agoda.training.SringsList

object stringsStats {
  import scala.collection.mutable.Map

  def getStatsInfo(input: String): (String, String, Char, Map[String, List[String]]) = {

    val list = input split " " toList
    val lettersList = input.split("").filter(_ != "").filter(_ != " ").toList
    (
      (list sortWith (_.length > _.length))(0),
      list.sortWith((a: String, b: String) => { list.filter(_ == a).length > list.filter(_ == b).length })(0),
      lettersList.sortWith((a: String, b: String) => { lettersList.filter(_ == a).length > lettersList.filter(_ == b).length })(0)(0),
      lettersList.map((s: String) => (s, list.filter(_ contains s))).foldLeft(Map[String, List[String]]()) { (m, s) => m + (s._1 -> s._2) }
    )

  }
}
