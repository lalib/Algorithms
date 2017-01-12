package com.bilalalp.algorithms.search

import scala.annotation.tailrec

object BinarySearch {

  def search[T](elementArray: Array[T], element: T)(implicit ordering: Ordering[T]): Int = {

    var minIndex = 0
    var maxIndex = elementArray.length - 1

    while (minIndex <= maxIndex) {
      val index: Int = (maxIndex + minIndex) / 2
      val comparisonResult = ordering.compare(elementArray(index), element)

      if (comparisonResult == 0) return index
      else if (comparisonResult > 0) maxIndex = index - 1
      else minIndex = index + 1

    }

    -1
  }

  def searchRecursively[T](elementArray: Array[T], element: T)(implicit ordering: Ordering[T]): Int = {

    @tailrec
    def innerSearch(minIndex: Int, maxIndex: Int): Int = {

      if (minIndex >= maxIndex) -1

      val index: Int = (maxIndex + minIndex) / 2
      val comparisonResult = ordering.compare(elementArray(index), element)

      if (comparisonResult == 0) index
      else if (comparisonResult > 0) innerSearch(minIndex, index - 1)
      else innerSearch(index + 1, maxIndex)

    }

    innerSearch(0, elementArray.length - 1)
  }
}