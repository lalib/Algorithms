package com.bilalalp.algorithms.datastructure.tree

import org.scalatest.FlatSpec

class BinarySearchTreeTest extends FlatSpec {

  "BinarySearchTree" should "add elements to the tree" in {
    val binarySearchTree: BinarySearchTree[Int] = new BinarySearchTree[Int]()
    binarySearchTree.insert(10)
    binarySearchTree.insert(6)
    binarySearchTree.insert(15)
    binarySearchTree.insert(16)
    binarySearchTree.insert(14)
    binarySearchTree.insert(3)
    binarySearchTree.insert(8)

    assert(binarySearchTree.size() == 7)
  }

  it should "find the element" in {
    val binarySearchTree: BinarySearchTree[Int] = new BinarySearchTree[Int]()
    binarySearchTree.insert(10)
    binarySearchTree.insert(6)
    binarySearchTree.insert(15)
    binarySearchTree.insert(16)
    binarySearchTree.insert(14)
    binarySearchTree.insert(3)
    binarySearchTree.insert(8)

    val searchResult = binarySearchTree.search(14)
    assert(searchResult != null)
    assert(searchResult.element == 14)
  }

  it should "not find the element" in {
    val binarySearchTree: BinarySearchTree[Int] = new BinarySearchTree[Int]()
    binarySearchTree.insert(10)
    binarySearchTree.insert(6)
    binarySearchTree.insert(15)
    binarySearchTree.insert(16)
    binarySearchTree.insert(14)
    binarySearchTree.insert(3)
    binarySearchTree.insert(8)

    assert(binarySearchTree.search(7) == null)
  }

  it should "should find the parent" in {
    val binarySearchTree: BinarySearchTree[Int] = new BinarySearchTree[Int]()
    binarySearchTree.insert(10)
    binarySearchTree.insert(6)
    binarySearchTree.insert(15)
    binarySearchTree.insert(16)
    binarySearchTree.insert(14)
    binarySearchTree.insert(3)
    binarySearchTree.insert(8)

    assert(binarySearchTree.findParent(16).element == 15)
  }

  it should "should find the root" in {
    val binarySearchTree: BinarySearchTree[Int] = new BinarySearchTree[Int]()
    binarySearchTree.insert(10)
    binarySearchTree.insert(6)
    binarySearchTree.insert(15)
    binarySearchTree.insert(16)
    binarySearchTree.insert(14)
    binarySearchTree.insert(3)
    binarySearchTree.insert(8)

    assert(binarySearchTree.findParent(10) == null)
  }

  it should "should not find the parent" in {
    val binarySearchTree: BinarySearchTree[Int] = new BinarySearchTree[Int]()
    binarySearchTree.insert(10)
    binarySearchTree.insert(6)
    binarySearchTree.insert(15)
    binarySearchTree.insert(16)
    binarySearchTree.insert(14)
    binarySearchTree.insert(3)
    binarySearchTree.insert(8)

    assertThrows[RuntimeException](binarySearchTree.findParent(11))
  }

  it should "should delete the root element" in {
    val binarySearchTree: BinarySearchTree[Int] = new BinarySearchTree[Int]()
    binarySearchTree.insert(10)
    binarySearchTree.insert(6)
    binarySearchTree.insert(15)
    binarySearchTree.insert(16)
    binarySearchTree.insert(14)
    binarySearchTree.insert(3)
    binarySearchTree.insert(8)

    binarySearchTree.delete(10)
  }

  it should "should delete the element 15" in {
    val binarySearchTree: BinarySearchTree[Int] = new BinarySearchTree[Int]()
    binarySearchTree.insert(10)
    binarySearchTree.insert(6)
    binarySearchTree.insert(15)
    binarySearchTree.insert(16)
    binarySearchTree.insert(14)
    binarySearchTree.insert(3)
    binarySearchTree.insert(8)

    binarySearchTree.delete(15)
  }
}
