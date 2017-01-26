package com.bilalalp.algorithms.sorting

trait AbstractSort {

  def sort[T:Manifest](elementArray: Array[T])(implicit ordering: Ordering[T]): Unit
}