package org.example

// 추상 클래스 정의. 추상 메서드, 변수를 하나 이상 가지고 있는 클래스를 추상 클래스라 하며, abstract 키워드를 통해 선언한다.
// open 키워드 없이 하위 클래스에게 상속될 수 있으며, 하위 클래스는 반드시 추상 메서드와 변수를 구현해야만한다.
abstract class AbstractEx(val shape: String, val color: String) {

    // 추상 프로퍼티
    abstract val width: Double

    // 추상 메서드
    abstract fun draw(): String

    fun display() {
        println("$shape 출력")
    }
}

// 추상 클래스를 상속받은 클래스. 해당 추상 프로퍼티를 주 생성자로 오버라이드하여 초기화했다.
class Circle(shape: String, color: String, override val width: Double): AbstractEx(shape, color) {

    // 추상 메서드의 구현
    override fun draw() = "$shape 그리기"
}


// 하위 클래스를 만들지 않고 단일 인스턴스로도 추상 클래스의 객체 생성이 가능하다.
val square = object: AbstractEx("square", "red") {
    override val width: Double by lazy {
        0.1
    }

    override fun draw(): String {
        TODO("Not yet implemented")
    }
}