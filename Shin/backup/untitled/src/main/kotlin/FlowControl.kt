package org.example

// if, when, for 등 흐름 제어 및 반복문

class FlowControl {
    val num1: Int = 1
    val num2: Int = 2

    // if는 자바의 사용과 같음. 다만 변수에 if 식 할당 가능
    fun max(a: Int, b: Int): Int {
        val max = if (a > b) {
            println("max is a")
            a                       // max에 a 할당
        } else {
            println("max is b")
            b                       // max에 b 할당
        }
        return max
    }

    fun range(num: Int) {
        if (num in 0..100) {         // 범위 연산자 in. (0..20)
            println(num)
        }
        else println("범위를 벗어남")
    }

    // when 구문. java의 switch에 해당함. break 필요 없음.
    fun switch(num: Int) {
        when (num) {
            is Int -> println("정수형")                    // is 키워드로 검사
            1 -> println("num == 1")
            2,3 -> println("num == 2 or 3")
            in 1..10 -> println("1 <= num <= 10")
            else -> println("범위를 벗어남")
        }
    }

    // for 반복문. java와 같은 for(i=0; i<10; i++) 식을 사용하지 않음
    fun add() {
        var result = 0
        for (x in 1..10) {
            result += x
        }
        println(result)
    }

    // for문 downTo. 하행 반복
    fun down() {
        for (i in 5 downTo 1) {
            println(i)                  // 5, 4, 3, 2, 1
        }
    }

    // for문 step.
    fun step() {
        for (i in 1..10 step 2) {
            println(i)                  // 1, 3, 5, 7, 9
        }
    }
}