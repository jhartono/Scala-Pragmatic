package com.jhartono.pragmatic.scala.exercise1

class TicTacToeBoard(size: Int) {
	
  val board = Array.ofDim[Char](size, size)
	
  def this() {
    this(3)
  }
  
  def getSize() = size
  
  def put(char: Char, position: (Int, Int)): Boolean = {
    if (position._1 > size - 1 || position._2 > size - 1) {
      return false
    }
    
    board(position._1)(position._2) = char
    return true
  }
  
  def get(position: (Int, Int)): Char = {
    if (position._1 > size - 1 || position._2 > size - 1) {
      return 0
    }
    return board(position._1)(position._2)
  }
  
  override def toString(): String = {
    val builder = new StringBuilder()
    
    for (row <- 0 until size) {
      if (row > 0) {
        builder.append('\n')
      }
      for (column <- 0 until size) {
        if (board(row)(column) == 0) {
          builder.append("_")
        }
        builder.append(board(row)(column))
      }
    }
    builder.toString()
  }
  
}