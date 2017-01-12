package com.bilalalp.algorithms.searching

import org.scalatest.FlatSpec

class BinarySearchTest extends FlatSpec {

  val sortedNumberArray: Array[Int] = Array(1, 2, 3, 4, 5, 6, 7, 8, 9)

  val unsortedNumberArray: Array[Int] = Array(1, 2, 6, 5, 4, 3, 7, 8, 9)

  "Binary Search" should "return the exact index" in {
    assert(BinarySearch.search(sortedNumberArray, 7) == 6)
  }

  it should "return the 5th index" in {
    assert(BinarySearch.search(sortedNumberArray, 6) == 5)
  }

  it should "not find anything and return -1" in {
    assert(BinarySearch.search(sortedNumberArray, 10) == -1)
  }

  it should "return the 6th index" in {
    assert(BinarySearch.searchRecursively(sortedNumberArray, 7) == 6)
  }

  it should "not find anything among unsorted numbers and return -1" in {
    assert(BinarySearch.search(unsortedNumberArray, 3) == -1)
  }

  it should "return 8th index" in {
    assert(BinarySearch.search(sortedNumberArray,9) == 8)
  }
}