package com.jhartono.pragmatic.scala.exercise1

object TicTacToe {

  def main(args: Array[String]): Unit = { 
    val ticTacToeBoard = new TicTacToeBoard()
    
    ticTacToeBoard.put('X', (0, 0))
    ticTacToeBoard.put('X', (1, 1))
    ticTacToeBoard.put('X', (2, 2))
    
    println(ticTacToeBoard.toString())
  }

}