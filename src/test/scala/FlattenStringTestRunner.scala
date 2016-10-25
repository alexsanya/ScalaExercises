import org.scalatest.FunSuite

class FlattenStringTestRunner extends FunSuite {

  test("should return flattened chars list form strings list") {
    val input = "a bc def ghij"
    val output = input.split(" ").map(_ split "").flatten.filter(_.length > 0).map(_(0)).toList
    assert(output == List('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j'))
  }
}
