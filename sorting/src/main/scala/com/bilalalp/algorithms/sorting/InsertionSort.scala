package com.bilalalp.algorithms.sorting

object InsertionSort extends AbstractSort {

  override def sort[T: Manifest](elementArray: Array[T])(implicit ordering: Ordering[T]): Unit = {

    for (i <- 1 until elementArray.length) {
      val element: T = elementArray(i)
      var j = i
      while (j > 0 && ordering.compare(elementArray(j - 1), element) > 0) {
        elementArray(j) = elementArray(j - 1)
        j = j - 1
      }
      elementArray(j) = element
    }
  }
}