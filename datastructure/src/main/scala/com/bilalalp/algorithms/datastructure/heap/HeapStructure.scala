package com.bilalalp.algorithms.datastructure.heap

import scala.annotation.tailrec

class HeapStructure[T: Manifest](implicit ordering: Ordering[T]) {

  private final val DEFAULT_SIZE: Int = 15

  private var heapArray: Array[T] = new Array[T](DEFAULT_SIZE)

  private var position: Int = 0

  def top(): T = heapArray(0)

  def display(): Unit = for (i <- 0 until position) println(heapArray(i))

  def insertArray(elements: Array[T]): Unit = elements.foreach(e => insert(e))

  def createHeap(elements: Array[T]): Unit = {
    position = 0
    heapArray = new Array[T](elements.length)
    elements.foreach(e => insert(e))
  }

  def insert(element: T): Unit = {
    if (position == heapArray.length) increaseSize()
    heapArray(position) = element
    position = position + 1
    heapify()
  }

  def extract(): T = {
    val element: T = top()
    heapArray(0) = heapArray(position - 1)
    position = position - 1
    sinkDown(0)
    element
  }

  @tailrec
  private def sinkDown(pos: Int): Unit = {
    var smallest: Int = pos
    if (2 * pos < position && ordering.compare(heapArray(smallest), heapArray(2 * pos)) > 0)
      smallest = 2 * pos
    else if (2 * pos + 1 < position && ordering.compare(heapArray(smallest), heapArray(2 * pos + 1)) > 0)
      smallest = 2 * pos + 1

    if (smallest != pos) {
      swap(pos, smallest)
      sinkDown(smallest)
    }
  }

  private def increaseSize(): Unit = {
    val tempArray: Array[T] = new Array[T](heapArray.length * 2)
    Array.copy(heapArray, 0, tempArray, 0, heapArray.length)
    heapArray = tempArray
  }

  private def heapify(): Unit = {
    var pos: Int = position - 1
    while (pos >= 0 && ordering.compare(heapArray(pos / 2), heapArray(pos)) > 0) {
      swap(pos, pos / 2)
      pos = pos / 2
    }
  }

  private def swap(first: Int, second: Int): Unit = {
    val temp: T = heapArray(first)
    heapArray(first) = heapArray(second)
    heapArray(second) = temp
  }
}