package com.bilalalp.algorithms.datastructure

import org.scalatest.FlatSpec

class StackStructureTest extends FlatSpec {

  "Stack " should "add elements to the structure" in {
    val stackStructure: StackStructure[Int] = new StackStructure[Int]()
    stackStructure.push(10)
    stackStructure.push(6)
    stackStructure.push(15)
    stackStructure.push(16)
    stackStructure.push(14)
    stackStructure.push(3)
    stackStructure.push(8)

    assert(stackStructure.size() == 7)
  }

  "Stack " should "remove elements from the structure" in {
    val stackStructure: StackStructure[Int] = new StackStructure[Int]()
    stackStructure.push(10)
    stackStructure.push(6)
    stackStructure.push(15)
    stackStructure.push(16)
    stackStructure.push(14)
    stackStructure.push(3)
    stackStructure.push(8)

    assert(stackStructure.pop == 8)
    assert(stackStructure.pop == 3)
    assert(stackStructure.pop == 14)
    assert(stackStructure.pop == 16)
    assert(stackStructure.pop == 15)
    assert(stackStructure.pop == 6)
    assert(stackStructure.pop == 10)

    assert(stackStructure.size() == 0)
  }

  "Stack " should "return the first element from the structure" in {
    val stackStructure: StackStructure[Int] = new StackStructure[Int]()
    stackStructure.push(10)
    stackStructure.push(6)
    stackStructure.push(15)
    stackStructure.push(16)
    stackStructure.push(14)
    stackStructure.push(3)
    stackStructure.push(8)

    assert(stackStructure.peek() == 8)
    assert(stackStructure.size() == 7)
  }
}