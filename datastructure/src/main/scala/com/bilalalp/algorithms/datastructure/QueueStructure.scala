package com.bilalalp.algorithms.datastructure

import com.bilalalp.algorithms.datastructure.list.SingleLinkedList

class QueueStructure[T: Manifest] {

  var singleLinkedList: SingleLinkedList[T] = new SingleLinkedList[T]

  def isEmpty(): Boolean = singleLinkedList.size() == 0

  def enqueue(element: T): Unit = singleLinkedList.addToTail(element)

  def dequeue(): T = singleLinkedList.removeFromHead()

  def size(): Int = singleLinkedList.size()
}