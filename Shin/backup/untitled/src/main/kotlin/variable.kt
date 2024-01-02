package org.example

// 변수 선언. 기본형 변수는 모두 null을 허용하지 않음

const val constNum: Int = 0    // const = static. java의 static final과 같음

class variable {
    var variableNum: Int = 1        // 가변 타입 변수
    val valueNum: Int = 2           // 불변 변수. java의 final

    var nullableNum: Int? = null    // null 허용 변수

    val num1 = 1                     // 타입 추론이 가능할 경우 타입 생략 가능
    val num2 = 0.1
    val str = "hi"
}