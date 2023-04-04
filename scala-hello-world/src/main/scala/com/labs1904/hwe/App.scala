package com.labs1904.hwe

object App {
  def main(args: Array[String]): Unit = {
    println("Hello World")
    println(greeting("Joe"))
  }

  def greeting(name: String): String = {
    "Hello " + name
  }
}