package com.bilalalp.algorithms.datastructure.heap

import org.scalatest.FlatSpec

class HeapStructureTest extends FlatSpec {

  "Heap" should "add elements" in {
    val elementArray: Array[Int] = Array(10, 30, 50, 3, 6)
    val heapStructure: HeapStructure[Int] = new HeapStructure[Int]()
    heapStructure.createHeap(elementArray)
    assert(heapStructure.top == 3)
  }

  it should "return top elements" in {
    val elementArray: Array[Int] = Array(10, 30, 50, 3, 6)
    val heapStructure: HeapStructure[Int] = new HeapStructure[Int]()
    heapStructure.createHeap(elementArray)

    assert(heapStructure.extract == 3)
    assert(heapStructure.extract == 6)
    assert(heapStructure.extract == 10)
    assert(heapStructure.extract == 30)
    assert(heapStructure.extract == 50)
  }

  it should "return new added elements" in {
    val elementArray: Array[Int] = Array(10, 30, 50, 3, 6)
    val heapStructure: HeapStructure[Int] = new HeapStructure[Int]()
    heapStructure.createHeap(elementArray)

    assert(heapStructure.extract == 3)
    assert(heapStructure.extract == 6)

    heapStructure.insert(20)

    assert(heapStructure.extract == 10)
    assert(heapStructure.extract == 20)
    assert(heapStructure.extract == 30)
    assert(heapStructure.extract == 50)

    heapStructure.insertArray(Array[Int](20, 5, 3, 0))
    assert(heapStructure.extract == 0)
    assert(heapStructure.extract == 3)
  }
}
