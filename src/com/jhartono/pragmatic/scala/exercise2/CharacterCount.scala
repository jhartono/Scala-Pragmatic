package com.jhartono.pragmatic.scala.exercise2

object CharacterCount {

  def main(args: Array[String]): Unit = { 
    val stringList = "This is a beautiful day".split(" ").toList
    println(count(stringList));
  }
  
  def count(list: List[String]):Int = {
    list.foldLeft(0)((total, x) => x.toCharArray().foldLeft(total)((total, _) => total + 1))
  }

}