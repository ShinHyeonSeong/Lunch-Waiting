package org.example

interface Animal {
    var category: String                // 추상 프로퍼티
    fun eat()                           // 추상 메서드
    fun speak() {                       // 일반 메서드
        println("$category crying")
    }
}

class Cat(override var category: String) : Animal {
    override fun eat() {
        println("The cat is eating fish")
    }

}

fun main() {

}