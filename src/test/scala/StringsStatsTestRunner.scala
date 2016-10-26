import org.scalatest.FunSuite
import agoda.training.SringsList.stringsStats._

class StringsStatsTestRunner extends FunSuite {

  test("should return correct statistic info") {
    val INPUT = "Use a trait to define a generic queue of strings with 'put' and 'get' methods, and create a class that implements it using an array. Include tests ttt"
    val (longestWord, mostCommonWord, mostCommonLetter, wordsLettersMap) = getStatsInfo(INPUT)
    assert(longestWord == "implements")
    assert(mostCommonWord == "a")
    assert(mostCommonLetter == 't')
    println(wordsLettersMap)
  }
}
