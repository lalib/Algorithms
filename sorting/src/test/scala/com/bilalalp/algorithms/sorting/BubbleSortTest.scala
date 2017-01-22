package com.bilalalp.algorithms.sorting

import org.scalatest.FlatSpec

class BubbleSortTest  extends FlatSpec {

  val unsortedNumberArray: Array[Int] = Array(1, 65, 6, 52, 409, 33, 70, -2, 9)

  val sortedNumberArray: Array[Int] = Array(-2, 1, 6, 9, 33, 52, 65, 70, 409)

  "Bubble Sort" should "sort the array" in {
    BubbleSort.sort(unsortedNumberArray)
    assert(sortedNumberArray === unsortedNumberArray)
  }

  it should "should return the sorted array" in {
    val clonedArray = sortedNumberArray.clone()
    BubbleSort.sort(sortedNumberArray)
    assert(sortedNumberArray === clonedArray)
  }
}