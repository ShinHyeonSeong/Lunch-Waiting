package org.example

class NestedClassEx {
    val word: String = "Hi"


    inner class A {                 // inner 키워드를 사용한 이너 클래스.
        fun greeting() = word       // 외부 클래스의 num 필드나 다른 메서드에 접근할 수 있다.
    }

    class B {                       // 아무 키워드가 없는 클래스는 중첩 클래스이며, 정적 클래스(static)처럼 사용된다.
        fun greeting() = "Hello"    // 외부 클래스의 num 프로퍼티나 다른 메서드에 접근할 수 없다.
    }
}

fun main() {
    val outerClass = NestedClassEx()
    val a = outerClass.A()          // 외부 객체 생성이 선행되어야만 생성 가능
    val b = NestedClassEx.B()       // 외부 객체 생성 없이 B 사용 가능. (static)

    println(a.greeting())
    println(b.greeting())
}