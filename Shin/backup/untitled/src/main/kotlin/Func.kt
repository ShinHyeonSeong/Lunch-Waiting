package org.example

// 함수 선언 및 사용

open class Func {
    val num1: Int = 1
    val num2: Int = 2

    // num1 + num2 를 반환하는 함수. 파라미터 뒤에 반환 타입을 선언함.
    fun add(num1: Int): Int {
        return num1 + num1
    }

    // 반환타입 생략시 Unit. Unit은 자바의 void와 같음.
    fun hello() {
        println("hello")
    }

    // 람다식 (타임 명시)
    val sum: (Int, Int) -> Int = {x, y -> x + y}

    // 변수 타입을 식 안에 선언 (타입 추론)
    val mul = {x: Int, y: Int -> x * y}

    // 매개변수가 하나일 경우 -> 표현 없이 it으로 대체 가능
    val add: (Int) -> Int = {it + 1}

    // 고차 함수. 함수의 매개변수로 함수를 받거나 함수 자체를 반환할 수 있다.
    fun high(name: String, body: (Int) -> Int): Int {       // 해당 고차함수의 매개변수는 name(String)과, Int 반환타입의 함수임
        println("name: $name")                              // name을 출력하고,
        val x = 1
        return body(x)                                      // 매개변수로 받은 함수 body에 x를 매개변수로 x를 전달하여 body의 반환값을 반환 (..)
    }

    // 따라서 해당 high 함수를 사용할 때는 다음과 같은 형태가 가능함
    // 1. 매개변수로 jack, 덧셈을 하는 람다함수를 전달.
    // 2. high의 동작에 따라 name: jack을 출력
    // 3. 매개변수로 전달한 람다식에 따라 1 + 1 값을 리턴받음.
    // result1은 2 값을 전달받게됨.
    val result1 = high("Jack", {x: Int -> x + x})

    // 람다함수를 매개변수 소괄호 바깥으로 빼내고 사용할 수도 있다.
    val result2 = high("Jack") {x: Int -> x + x}

    // 일반 함수를 전달할 때는 :: 기호를 붙여 사용한다.
    val result3 = high("Jack", ::add)



}