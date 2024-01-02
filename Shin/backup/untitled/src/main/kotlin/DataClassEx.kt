package org.example

// Data 클래스. 자바의 POJO와 같은 개념으로, 구현 로직을 가지지 않고 순수한 데이터 객체를 포함한다.
// getter, setter, toString(), equals(), hashCode() 등이 자동 생성된다.

// 데이터 클래스의 주 생성자는 최소한 하나의 매개변수를 가져야하며, 주 생성자의 모든 매개변수는 var, val로 프로퍼티를 겸해야한다.
// 데이터 클래스는 abstract, open, sealed, inner 키워드를 사용할 수 없다.
data class DataClassEx(var name: String, var age: Int) {}

fun main() {
    val data1 = DataClassEx("Jhon", 20)
    val data2 = DataClassEx("Jhon", 20)
    val data3 = data1.copy("Jack")                      // data1 복사. 다만 이름만 바꿈

    println(data1 == data2)                                 // true. 객체의 의미 값을 비교하기 때문임
    println(data1.equals(data2))                            // true
    println("${data1.hashCode()}, ${data2.hashCode()}")     // 고유값 역시 동일함. (..?)
    println(data3.toString())

}