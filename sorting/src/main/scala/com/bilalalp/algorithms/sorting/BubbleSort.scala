package com.bilalalp.algorithms.sorting

object BubbleSort extends AbstractSort {

  override def sort[T: Manifest](elementArray: Array[T])(implicit ordering: Ordering[T]): Unit = {

    var swapped: Boolean = true

    while (swapped) {

      swapped = false
      for (i <- 0 until elementArray.length - 1) {
        if (ordering.compare(elementArray(i), elementArray(i + 1)) > 0) {
          swapped = true
          val tempValue: T = elementArray(i)
          elementArray(i) = elementArray(i + 1)
          elementArray(i + 1) = tempValue
        }
      }
    }
  }
}