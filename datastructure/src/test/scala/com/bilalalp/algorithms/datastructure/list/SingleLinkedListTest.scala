package com.bilalalp.algorithms.datastructure.list

import org.scalatest.FlatSpec

class SingleLinkedListTest extends FlatSpec {

  "SingleLinkedList" should "add elements" in {
    val singleLinkedList :SingleLinkedList[Int] = new SingleLinkedList[Int]
    singleLinkedList.addToHead(4)
    singleLinkedList.addToHead(3)
    singleLinkedList.addToHead(5)
    assert(singleLinkedList.size() == 3)
  }

  "SingleLinkedList" should "add elements to tail" in {
    val singleLinkedList :SingleLinkedList[Int] = new SingleLinkedList[Int]
    singleLinkedList.addToTail(4)
    singleLinkedList.addToTail(3)
    singleLinkedList.addToTail(5)
    assert(singleLinkedList.size() == 3)
  }

  "SingleLinkedList" should "get the element by index" in {
    val singleLinkedList :SingleLinkedList[Int] = new SingleLinkedList[Int]
    singleLinkedList.addToTail(4)
    singleLinkedList.addToTail(3)
    singleLinkedList.addToTail(5)
    assert(singleLinkedList.get(2) == 5)
  }

  "SingleLinkedList" should "return null for get the element by index" in {
    val singleLinkedList :SingleLinkedList[Int] = new SingleLinkedList[Int]
    singleLinkedList.addToTail(4)
    singleLinkedList.addToTail(3)
    singleLinkedList.addToTail(5)
    assert(singleLinkedList.get(4) == 0)
  }

  "SingleLinkedList" should "remove from the head" in {
    val singleLinkedList :SingleLinkedList[Int] = new SingleLinkedList[Int]
    singleLinkedList.addToTail(4)
    singleLinkedList.addToTail(3)
    singleLinkedList.addToTail(5)
    singleLinkedList.removeFromHead()
    assert(singleLinkedList.size() == 2)
  }

  "SingleLinkedList" should "remove from the tail" in {
    val singleLinkedList :SingleLinkedList[Int] = new SingleLinkedList[Int]
    singleLinkedList.addToTail(4)
    singleLinkedList.addToTail(3)
    singleLinkedList.addToTail(5)
    singleLinkedList.removeFromTail()
    assert(singleLinkedList.size() == 2)
  }
}
