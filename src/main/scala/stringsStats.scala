package agoda.training.SringsList

object stringsStats {
  import scala.collection.mutable.Map

  private var longestWord = ""
  private var mostCommonWord: Option[String] = Option.empty
  private var mostCommonLetter: Option[Char] = Option.empty
  private val wordsMap: Map[String, Int] = Map.empty
  private val lettersMap: Map[Char, Int] = Map.empty
  var wordsLettersMap: Map[Char, Set[String]] = Map.empty

  private def adjustMap[T](key: T, keyTop: Option[T], map: Map[T, Int]): T = {
    var number = 1
    if (map contains key ) number = map(key) + 1
    map += (key -> number)

    var result = key
    if (!keyTop.isEmpty && (number < map(keyTop get))) result = keyTop.get
    result
  }

  private def checkLongestWord(word: String): Unit = {
    if (word.length > this.longestWord.length) {
      this.longestWord = word
    }
  }

  private def agjustLettersMap(word: String): Unit = {
    (0 until word.length).map(n => word.charAt(n)).foreach((c: Char) => {
      this.mostCommonLetter = Some(this.adjustMap[Char](c, mostCommonLetter, lettersMap))
      if (!this.wordsLettersMap.contains(c)) wordsLettersMap(c) = Set(word)
      wordsLettersMap(c) += word
    })
  }

  def getStatsInfo(input: String): (String, String, Char) = {

    input split " " foreach((s: String) => {
      this.checkLongestWord(s)
      this.mostCommonWord = Some(this.adjustMap[String](s, mostCommonWord, wordsMap))
      this.agjustLettersMap(s)
    })

    (this.longestWord, this.mostCommonWord.get, this.mostCommonLetter.get)
  }
}
