package com.bilalalp.algorithms.searching

import org.scalatest.FlatSpec

class SequentialSearchTest extends FlatSpec{

  val numberArray: Array[Int] = Array(1, 2, 6, 5, 4, 3, 7, 8, 9)

  "Sequential Search" should "return the exact index" in {
    assert(BinarySearch.search(numberArray, 7) == 6)
  }

  it should "return -1" in {
    assert(BinarySearch.search(numberArray, 12) == -1)
  }
}
