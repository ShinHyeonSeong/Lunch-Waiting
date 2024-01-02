package org.example

// 코틀린의 클래스 선언. open 키워드를 써줘야 상속을 허용한다.
// 클래스 선언부에 파라미터를 넣을 시, 이는 주 생성자이며, 보통의 경우 constructor 키워드를 생략한다.
// 만약 매개변수를 변수형으로 선언할 경우, 이는 생성자의 매개변수 뿐만 아니라 클래스의 속성도 겸하게 된다.
// 주 생성자의 매개변수에 값을 초기화하면, 이는 각 변수의 초기값으로 지정된다.
open class Person constructor(var name: String = "Jack", var age: Int = 20) {

//    부 생성자. 주 생성자에 초기값을 할당함으로써 생성자 오버로딩이 불필요해졌다.
//    constructor(name: String): this() {
//        this.name = name
//        this.age = 1
//    }

    // 초기화 블럭. 객체 생성 시 호출된다.
    init {
        println("name: $name, age: $age")
    }

    // 상속받은 클래스가 해당 함수를 오버라이딩 하기 위해서는 open 키워드가 명시되어야함
    open fun printType() {
        println("Person")
    }
}

// Person 클래스를 상속받는 Student 클래스
// name, age를 받아 상위 클래스가 가졌던 속성으로 전달, 또한 해당 클래스만의 새로운 type 변수를 선언함
class Student(name: String, age: Int, var type: String = "middle"): Person(name, age) {

    // 상위 클래스 Person의 함수를 오버라이딩함. 오버라이드시 override 키워드를 명시해야함
    override fun printType() {
        println(type)
    }
}

// 주 생성자를 클래스 내에 명시적으로 선언하는 경우. 자바와 형식이 비슷함
class Doctor: Person {
    var type: String
        get() {return field}/* = field */   // getter 명시적 선언. 보조 필드(field) 대신 변수 자체를 사용할 경우 무한 재귀에 빠짐.
        set(value) {
            field = value                   // setter 명시적 선언.
        }

    lateinit var bloodType: String          // lateinit 지연 초기화. 추후 객체 생성 후 setter를 통해 초기화할 수 있음.

    val gender by lazy {                    // by lazy 지연 초기화. 추후 객체 생성 후 해당 변수를 호출하면 초기화됨.
        println("by lazy called")
        "male"                          // 변수 사용 시 "male" 값으로 초기화됨
    }

    constructor(name: String, age: Int, type: String): super(name, age) {   // super 키워드로 상위 클래스를 호출하여 생성자로 전달함.
        this.type = type
    }

    override fun printType() {
        println(type)
    }
}

// 위임(delegation)
interface Car {                                                 // 위임을 구현하기 위한 인터페이스
    fun go(): String
}
class VanType(val power: String): Car {                         // 위임을 구현하기 위한 클래스
    override fun go() = "는 짐을 적재하며 $power 마력을 가집니다."
}
class SportCar(val power: String): Car {                        // 위임을 구현하기 위한 클래스
    override fun go() = "는 경주용에 사용되며 $power 마력을 가집니다."
}

// 매개변수로 받은 클래스에 변수 및 메서드 구현을 위임하는 클래스.
// Car 인터페이스를 구현했으므로 go() 메서드를 반드시 구현해야하지만, 매개변수로 받은 impl 클래스에게 go() 메서드 구현을 위임하였다.
// 따라서 해당 클래스 객체를 생성할 때 매개변수로 들어가는 클래스에 따라서 go() 메서드의 내용이 달라지게 된다.
class CarModel(val model: String, impl: Car): Car by impl {

    fun carInfo() {                 // 따라서 carInfo 함수는 다형성을 가지게 된다.
        println("$model ${go()}")
    }
}