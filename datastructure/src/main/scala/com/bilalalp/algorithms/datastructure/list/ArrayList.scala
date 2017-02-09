package com.bilalalp.algorithms.datastructure.list

class ArrayList[T: Manifest] {

  private final val DEFAULT_SIZE: Int = 16

  var elements: Array[T] = new Array[T](DEFAULT_SIZE)

  var arrayIndex: Int = 0

  def add(element: T): Unit = {
    if (arrayIndex == elements.length) increaseArraySize()
    elements(arrayIndex) = element
    arrayIndex = arrayIndex + 1
  }

  def increaseArraySize(): Unit = {
    val newElementArray = new Array[T](elements.length * 2)
    for (i <- elements.indices) newElementArray(i) = elements(i)
    elements = newElementArray
  }

  def get(index: Int): T = {
    if (index > arrayIndex || index < 0) throw new IndexOutOfBoundsException
    elements(index)
  }

  def remove(index: Int): T = {
    if (index > arrayIndex || index < 0) throw new IndexOutOfBoundsException

    val deletedItem: T = elements(index)
    for (i <- index until arrayIndex) elements(i) = elements(i + 1)

    arrayIndex = arrayIndex - 1
    deletedItem
  }

  def add(index: Int, element: T): Unit = {
    if (arrayIndex == elements.length) increaseArraySize()

    for (i <- arrayIndex until index by -1) elements(i) = elements(i - 1)

    elements(index) = element
    arrayIndex = arrayIndex + 1
  }

  def size(): Int = arrayIndex
}
