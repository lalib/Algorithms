package com.bilalalp.algorithms.datastructure.list

import scala.annotation.tailrec

case class DoubleNode[T: Manifest](var value: T = null, var prev: DoubleNode[T] = null, var next: DoubleNode[T] = null)

class DoubleLinkedList[T: Manifest] {

  var head, tail: DoubleNode[T] = _

  def addToHead(element: T): Unit = {

    if (null == head) {
      head = new DoubleNode[T](element)
      tail = head
    } else {
      head = new DoubleNode[T](element, null, head)
      head.next.prev = head
    }
  }

  def size(): Int = {
    @tailrec
    def size(node: DoubleNode[T], acc: Int): Int = if (null != node) size(node.prev, acc + 1) else acc

    size(tail, 0)
  }
}