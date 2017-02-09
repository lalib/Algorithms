package com.bilalalp.algorithms.datastructure.list

import scala.annotation.tailrec

case class Node[T: Manifest](var value: T = null, var next: Node[T] = null)

class SingleLinkedList[T: Manifest] {

  var head, tail: Node[T] = _

  def addToHead(element: T): Unit = {
    head = new Node[T](element, head)
    if (null == tail) tail = head
  }

  def addToTail(element: T): Unit = {
    if (tail == null) {
      tail = new Node[T](element, null)
      head = tail
    } else {
      tail.next = new Node[T](element, null)
      tail = tail.next
    }
  }

  def size(): Int = {

    @tailrec
    def size(node: Node[T], acc: Int): Int = if (node != null) size(node.next, acc + 1) else acc

    size(head, 0)
  }

  def removeFromHead(): T = {

    if (head == null) return null.asInstanceOf[T]

    val nodeValue: T = head.value

    if (head == tail) {
      head = null
      tail = null
    } else head = head.next

    nodeValue
  }

  def removeFromTail(): T = {

    if (tail == null) return null.asInstanceOf[T]

    val nodeValue: T = tail.value

    if (head == tail) {
      head = null
      tail = null
    } else {
      var tempValue: Node[T] = head
      while (tempValue.next != tail) tempValue = tempValue.next
      tempValue.next = null
      tail = tempValue
    }

    nodeValue
  }

  def get(index: Int): T = {

    @tailrec
    def get(node: Node[T], ind: Int): T = {

      if (node != null)
        if (ind != 0) get(node.next, ind - 1)
        else node.value
      else
        null.asInstanceOf[T]
    }

    get(head, index)
  }

  def print(): Unit = {

    @tailrec
    def print(node: Node[T]): Unit = {
      println(node.value)
      if (node.next != null) print(node.next)
    }

    print(head)
  }
}