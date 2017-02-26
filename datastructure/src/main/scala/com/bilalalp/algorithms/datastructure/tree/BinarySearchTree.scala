package com.bilalalp.algorithms.datastructure.tree

import scala.annotation.tailrec

case class TreeNode[T: Manifest](var element: T, var left: TreeNode[T] = null, var right: TreeNode[T] = null)

class BinarySearchTree[T: Manifest](implicit ordering: Ordering[T]) {

  var tree: TreeNode[T] = _

  def insert(element: T): Unit = {

    @tailrec
    def insert(element: T, node: TreeNode[T]): Unit = {
      if (ordering.compare(node.element, element) >= 0) {
        if (null == node.left) node.left = new TreeNode[T](element)
        else insert(element, node.left)
      } else {
        if (null == node.right) node.right = new TreeNode[T](element)
        else insert(element, node.right)
      }
    }

    if (null == tree) tree = new TreeNode[T](element)
    else insert(element, tree)
  }

  def search(element: T): TreeNode[T] = {

    @tailrec
    def innerSearch(node: TreeNode[T]): TreeNode[T] = {
      if (null == node) return null

      val comparisonResult: Int = ordering.compare(node.element, element)
      if (0 == comparisonResult) node
      else if (comparisonResult > 0) innerSearch(node.left)
      else innerSearch(node.right)
    }

    innerSearch(tree)
  }

  def delete(element: T): Unit = {

    val parent = findParent(element)

    if (null != parent) {

      val foundElement = search(element)
      val minMax: TreeNode[T] = if (null != foundElement.left) findMax(foundElement.left) else findMin(foundElement.right)
      val parentOfMin = if (null != minMax) findParent(minMax.element) else null

      if (null != parent.left && foundElement.element == parent.left.element)
        parent.left = minMax
      else if (null != parent.right && foundElement.element == parent.right.element)
        parent.right = minMax

      if (null != parentOfMin.right && parentOfMin.right.element == minMax.element)
        parentOfMin.right = null
      else if (null != parentOfMin.left && parentOfMin.left.element == minMax.element)
        parentOfMin.left = null

      minMax.left = foundElement.left
      minMax.right = foundElement.right

    } else {

      val minMax: TreeNode[T] = if (null != tree.left) findMax(tree.left) else findMin(tree.right)
      val parentOfMin = if (null != minMax) findParent(minMax.element) else null

      if (null != parentOfMin) {
        if (null != parentOfMin.right && parentOfMin.right.element == minMax.element)
          parentOfMin.right = null
        else if (null != parentOfMin.left && parentOfMin.left.element == minMax.element)
          parentOfMin.left = null

        minMax.left = tree.left
        minMax.right = tree.right
        tree = minMax
      } else {
        tree = null
      }
    }
  }

  @tailrec
  private def findMax(node: TreeNode[T]): TreeNode[T] = {
    if (null != node)
      if (null != node.right) findMax(node.right)
      else if (null != node.left) findMax(node.left)
      else node
    else null
  }

  @tailrec
  private def findMin(node: TreeNode[T]): TreeNode[T] = {
    if (null != node)
      if (null != node.left) findMin(node.left)
      else if (null != node.right) findMin(node.right)
      else node
    else null
  }

  def findParent(e: T): TreeNode[T] = {

    @tailrec
    def findParent(element: T, node: TreeNode[T]): TreeNode[T] = {

      if (null == node) throw new RuntimeException("The element does not exist!")

      if (null != node.left) {
        val comparisonResult: Int = ordering.compare(element, node.left.element)
        if (0 == comparisonResult) return node
      }

      if (null != node.right) {
        val comparisonResult: Int = ordering.compare(element, node.right.element)
        if (0 == comparisonResult) return node
      }

      val comparisonResult = ordering.compare(element, node.element)
      if (0 >= comparisonResult) findParent(e, node.left)
      else findParent(e, node.right)
    }

    if (0 == ordering.compare(e, tree.element)) null
    else findParent(e, tree)
  }

  def size(): Int = {

    def size(node: TreeNode[T], acc: Int): Int = {

      if (null == node || (null == node.left && null == node.right)) acc
      else if (null != node.left && null != node.right) size(node.left, 1) + size(node.right, 1) + acc
      else if (null != node.left) size(node.left, acc + 1)
      else size(node.right, acc + 1)
    }

    if (null == tree) 0
    else size(tree, 1)
  }
}
