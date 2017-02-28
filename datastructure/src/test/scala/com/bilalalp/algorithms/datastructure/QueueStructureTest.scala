package com.bilalalp.algorithms.datastructure

import org.scalatest.FlatSpec

class QueueStructureTest extends FlatSpec{

  "Queue " should "add elements to the structure" in {
    val queueStructure: QueueStructure[Int] = new QueueStructure[Int]()
    queueStructure.enqueue(10)
    queueStructure.enqueue(6)
    queueStructure.enqueue(15)
    queueStructure.enqueue(16)
    queueStructure.enqueue(14)
    queueStructure.enqueue(3)
    queueStructure.enqueue(8)

    assert(queueStructure.size() == 7)
  }

  it should "remove elements to the structure" in {
    val queueStructure: QueueStructure[Int] = new QueueStructure[Int]()
    queueStructure.enqueue(10)
    queueStructure.enqueue(6)
    queueStructure.enqueue(15)
    queueStructure.enqueue(16)
    queueStructure.enqueue(14)
    queueStructure.enqueue(3)
    queueStructure.enqueue(8)

    assert(queueStructure.size() == 7)

    assert(queueStructure.dequeue() == 10)
    assert(queueStructure.dequeue() == 6)
    assert(queueStructure.dequeue() == 15)
    assert(queueStructure.dequeue() == 16)
    assert(queueStructure.dequeue() == 14)
    assert(queueStructure.dequeue() == 3)
    assert(queueStructure.dequeue() == 8)
    assert(queueStructure.isEmpty())
  }
}
