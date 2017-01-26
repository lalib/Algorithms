package com.bilalalp.algorithms.sorting

object MergeSort extends AbstractSort {

  override def sort[T: Manifest](elementArray: Array[T])(implicit ordering: Ordering[T]): Unit = {
    val newArray = new Array[T](elementArray.length)
    mergeSort(elementArray, newArray, 0, elementArray.length - 1)
  }

  def mergeSort[T](elementArray: Array[T], tempElementArray: Array[T], left: Int, right: Int)(implicit ordering: Ordering[T]): Unit = {
    if (left < right) {
      val center: Int = (left + right) / 2
      mergeSort(elementArray, tempElementArray, left, center)
      mergeSort(elementArray, tempElementArray, center + 1, right)
      merge(elementArray, tempElementArray, left, center + 1, right)
    }
  }

  def merge[T](elementArray: Array[T], tempElementArray: Array[T], left: Int, right: Int, rightEnd: Int)(implicit ordering: Ordering[T]): Unit = {

    val leftEnd: Int = right - 1
    var k: Int = left
    val num: Int = rightEnd - left + 1
    var rightChange: Int = right
    var leftChange: Int = left
    var rightEndChange: Int = rightEnd

    while (left <= leftEnd && rightChange <= rightEnd) {
      k = k + 1
      if (ordering.compare(elementArray(leftChange), elementArray(rightChange)) <= 0) {
        leftChange = leftChange + 1
        tempElementArray(k) = elementArray(leftChange)
      } else {
        rightChange = rightChange + 1
        tempElementArray(k) = elementArray(rightChange)
      }
    }

    while (leftChange <= leftEnd) {
      k = k + 1
      leftChange = leftChange + 1
      tempElementArray(k) = elementArray(leftChange)
    }

    while (right <= rightEnd) {
      k = k + 1
      rightChange = rightChange + 1
      tempElementArray(k) = elementArray(rightChange)
    }

    for (i <- Range(0, num)) {
      rightEndChange = rightEndChange - 1
      elementArray(rightEndChange) = tempElementArray(rightEndChange)
    }
  }
}