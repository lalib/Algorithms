package com.bilalalp.algorithms.datastructure

import com.bilalalp.algorithms.datastructure.list.SingleLinkedList

class StackStructure[T: Manifest] {

  var singleLinkedList: SingleLinkedList[T] = new SingleLinkedList[T]

  def push(element: T): Unit = singleLinkedList.addToHead(element)

  def pop(): T = singleLinkedList.removeFromHead()

  def size(): Int = singleLinkedList.size()

  def peek(): T = singleLinkedList.get(0)
}