package com.jhartono.pragmatic.scala.exercise1

object TicTacToe {

  def main(args: Array[String]): Unit = { 
    val ticTacToeBoard = new TicTacToeBoard()
    
    ticTacToeBoard.put('X', (0, 2))
    ticTacToeBoard.put('X', (1, 1))
    ticTacToeBoard.put('X', (2, 0))
  
    println(ticTacToeBoard.toString())
    println(hasTie(ticTacToeBoard))
  }
  
  def hasTie(board: TicTacToeBoard): Boolean = {
    hasDownDiagonalTie(board) || hasUpDiagonalTie(board) || hasHorizontalTie(board) || hasVerticalTie(board)
  }
  
  def hasDownDiagonalTie(board: TicTacToeBoard): Boolean = {
    val firstChar = board.get((0, 0))
    if (firstChar != 0) {
	    for (down <- 1 until board.boardSize()) {
	      if (!board.get((down, down)).equals(firstChar)) {
	        return false
	      }
	    }
	} else {
	  return false
	}
    return true
  }
  
  def hasUpDiagonalTie(board: TicTacToeBoard): Boolean = {
    val firstChar = board.get((0, board.boardSize() - 1))
    if (firstChar != 0) {
	    for (up <- 1 until board.boardSize()) {
	      if (!board.get((up, board.boardSize() - 1 - up)).equals(firstChar)) {
	        return false
	      }
	    }
	} else {
	  return false
	}
    return true
  }
  
  def hasHorizontalTie(board: TicTacToeBoard): Boolean = {
    for (row <- 0 until board.boardSize) {
      val char = board.get((row, 0));
      var horizontalCount = 0
      if (char != 0) {
        horizontalCount = horizontalCount + 1
        for (column <- 1 until board.boardSize()) {
          if (board.get((row, column)).equals(char)) {
            horizontalCount = horizontalCount + 1
          }
        } 
        if (horizontalCount == board.boardSize()) {
          return true
        }
      }
    }
    return false
  }
  
  def hasVerticalTie(board: TicTacToeBoard): Boolean = {
    for (column <- 0 until board.boardSize) {
      val char = board.get((0, column));
      var verticalCount = 0
      if (char != 0) {
        verticalCount = verticalCount + 1
        for (row <- 1 until board.boardSize()) {
          if (board.get((row, column)).equals(char)) {
            verticalCount = verticalCount + 1
          }
        } 
        if (verticalCount == board.boardSize()) {
          return true
        }
      }
    }
    return false
  }

}