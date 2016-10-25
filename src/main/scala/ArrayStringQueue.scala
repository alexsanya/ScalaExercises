package agoda.training.traits

class ArrayStringQueue extends Queue[String] {

  private val MAX_NUM_OF_ITEMS = 100
  private val _data = new Array[String](MAX_NUM_OF_ITEMS)
  private var _headIndex = 0
  private var _tailIndex = 0

  def isEmpty(): Boolean = this._headIndex == this._tailIndex
  def isFull(): Boolean = (this._tailIndex + 1) % MAX_NUM_OF_ITEMS == this._headIndex

  def put(item: String): Queue[String] = {
    if (!this.isFull()) {
      this._data(this._tailIndex) = item
      this._tailIndex = (this._tailIndex + 1) % MAX_NUM_OF_ITEMS
    }
    this
  }

  def get(): String = {
    var result = "Empty"
    if (!this.isEmpty()) {
      val item = this._data(this._headIndex)
      this._headIndex = (this._headIndex + 1) % MAX_NUM_OF_ITEMS
      result = item
    }
    result
  }
}