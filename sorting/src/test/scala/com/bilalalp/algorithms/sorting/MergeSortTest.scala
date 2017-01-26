package com.bilalalp.algorithms.sorting

import org.scalatest.FlatSpec

class MergeSortTest extends FlatSpec {

  val unsortedNumberArray: Array[Int] = Array(1, 65, 6, 52, 409, 33, 70, -2, 9)

  val sortedNumberArray: Array[Int] = Array(-2, 1, 6, 9, 33, 52, 65, 70, 409)

  "Merge Sort" should "sort the array" in {
    MergeSort.sort(unsortedNumberArray)
    assert(sortedNumberArray === unsortedNumberArray)
  }

  it should "should return the sorted array" in {
    val clonedArray = sortedNumberArray.clone()
    MergeSort.sort(sortedNumberArray)
    assert(sortedNumberArray === clonedArray)
  }
}