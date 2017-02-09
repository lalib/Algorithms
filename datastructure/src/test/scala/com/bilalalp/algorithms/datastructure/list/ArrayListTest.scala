package com.bilalalp.algorithms.datastructure.list

import org.scalatest.FlatSpec

class ArrayListTest extends FlatSpec {

  "ArrayList" should "add elements" in {
    val arrayList: ArrayList[Int] = new ArrayList[Int]()
    arrayList.add(10)
    arrayList.add(20)
    arrayList.add(30)
    assert(arrayList.size() == 3)
  }

  it should "increase the list size" in {
    val arrayList: ArrayList[Int] = new ArrayList[Int]()

    for (i <- 0 until 100) arrayList.add(i)

    assert(arrayList.size() == 100)

    for (i <- 0 until 100) assert(i == arrayList.get(i))
  }

  it should "remove all elements from the list" in {

    val arrayList: ArrayList[Int] = new ArrayList[Int]()

    for (i <- 0 until 100) arrayList.add(i)

    assert(arrayList.size() == 100)

    while (arrayList.size() != 0) {
      val deletedIndex = arrayList.size() - 1
      val deletedElement = arrayList.get(deletedIndex)
      assert(arrayList.remove(deletedIndex) == deletedElement)
    }

    assert(arrayList.size() == 0)
  }

  it should "add elements to the middle" in {

    val arrayList: ArrayList[Int] = new ArrayList[Int]()

    for (i <- 0 until 15) arrayList.add(i)

    arrayList.add(15, 4)
    arrayList.add(6, 2)

    assert(arrayList.get(6) == 2)
    assert(arrayList.get(16) == 4)
  }
}