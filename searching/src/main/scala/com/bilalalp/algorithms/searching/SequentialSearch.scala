package com.bilalalp.algorithms.searching

object SequentialSearch {

  def search[T](elementArray: Array[T], element: T)(implicit ordering: Ordering[T]): Int = {

    for (i <- elementArray.indices)
      if (ordering.compare(element, elementArray(i)) == 0)
        return i

    -1
  }
}
