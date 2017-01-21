package com.bilalalp.algorithms.sorting

object SelectionSort {

  def sort[T](elementArray:Array[T])(implicit ordering: Ordering[T]):Unit= {

    for(i <- elementArray.indices; j <- i + 1 until elementArray.length){
        if(ordering.compare(elementArray(i), elementArray(j)) > 0){
          val tempValue = elementArray(i)
          elementArray(i) = elementArray(j)
          elementArray(j) =tempValue
      }
    }
  }
}