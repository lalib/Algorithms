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

    while (leftChange <= leftEnd && rightChange <= rightEnd) {
      if (ordering.compare(elementArray(leftChange), elementArray(rightChange)) <= 0) {
        tempElementArray(k) = elementArray(leftChange)
        leftChange = leftChange + 1
      } else {
        tempElementArray(k) = elementArray(rightChange)
        rightChange = rightChange + 1
      }
      k = k + 1
    }

    while (leftChange <= leftEnd) {
      tempElementArray(k) = elementArray(leftChange)
      leftChange = leftChange + 1
      k = k + 1
    }

    while (rightChange <= rightEnd) {
      tempElementArray(k) = elementArray(rightChange)
      rightChange = rightChange + 1
      k = k + 1
    }

    for (i <- Range(0, num)) {
      elementArray(rightEndChange) = tempElementArray(rightEndChange)
      rightEndChange = rightEndChange - 1
    }
  }
}