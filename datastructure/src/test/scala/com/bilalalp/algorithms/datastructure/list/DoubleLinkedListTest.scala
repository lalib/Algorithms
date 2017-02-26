package com.bilalalp.algorithms.datastructure.list

import org.scalatest.FlatSpec

class DoubleLinkedListTest extends FlatSpec {

  "DoubleLinkedList" should "add elements" in {
    val doubleLinkedList: DoubleLinkedList[Int] = new DoubleLinkedList[Int]
    doubleLinkedList.addToHead(4)
    doubleLinkedList.addToHead(3)
    doubleLinkedList.addToHead(5)
    assert(doubleLinkedList.size() == 3)
  }
}
