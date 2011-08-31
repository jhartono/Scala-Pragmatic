package com.jhartono.pragmatic.scala.exercise1

object TicTacToe {

  def main(args: Array[String]): Unit = { 
    println("Lets play TicTacToe!")
    print("Size: ")
    
    val size = Console.readInt()
    val ticTacToeBoard = new TicTacToeBoard(size)
    
    println(ticTacToeBoard.toString())
    
    var isPlayerOne = true
    while(!hasTie(ticTacToeBoard)) {
      var char = 'X'
      if (isPlayerOne) {
        println("Player One, your move")
      } else {
        char = 'O'
        println("Player Two, your move")
      }
      
      var validMove = false
      
      while (!validMove) {
        print("Row: ")
    	val row = Console.readInt()
        print("Column: ")
    	val column = Console.readInt()
        
        validMove = ticTacToeBoard.put(char, (row, column))
        if (!validMove) {
          println("Invalid move, please try again")
        }
      } 
      
      isPlayerOne = !isPlayerOne
      println(ticTacToeBoard.toString())
    }
    
    if (isPlayerOne) {
      println("Player Two wins")
    } else {
      println("Player One wins")
    }
    
  }
  
  def hasTie(board: TicTacToeBoard): Boolean = {
    hasDownDiagonalTie(board) || hasUpDiagonalTie(board) || hasHorizontalTie(board) || hasVerticalTie(board)
  }
  
  def hasDownDiagonalTie(board: TicTacToeBoard): Boolean = {
    val firstChar = board.get((0, 0))
    if (firstChar != 0) {
	    for (down <- 1 until board.getSize()) {
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
    val firstChar = board.get((0, board.getSize() - 1))
    if (firstChar != 0) {
	    for (up <- 1 until board.getSize()) {
	      if (!board.get((up, board.getSize() - 1 - up)).equals(firstChar)) {
	        return false
	      }
	    }
	} else {
	  return false
	}
    return true
  }
  
  def hasHorizontalTie(board: TicTacToeBoard): Boolean = {
    for (row <- 0 until board.getSize()) {
      val char = board.get((row, 0));
      var horizontalCount = 0
      if (char != 0) {
        horizontalCount = horizontalCount + 1
        for (column <- 1 until board.getSize()) {
          if (board.get((row, column)).equals(char)) {
            horizontalCount = horizontalCount + 1
          }
        } 
        if (horizontalCount == board.getSize()) {
          return true
        }
      }
    }
    return false
  }
  
  def hasVerticalTie(board: TicTacToeBoard): Boolean = {
    for (column <- 0 until board.getSize()) {
      val char = board.get((0, column));
      var verticalCount = 0
      if (char != 0) {
        verticalCount = verticalCount + 1
        for (row <- 1 until board.getSize()) {
          if (board.get((row, column)).equals(char)) {
            verticalCount = verticalCount + 1
          }
        } 
        if (verticalCount == board.getSize()) {
          return true
        }
      }
    }
    return false
  }

}