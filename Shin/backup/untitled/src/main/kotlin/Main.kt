package org.example

fun main() {

    // 함수
    val func: Func = Func()
    val result = func.result1
    println(result)

    // 객체
    val person: Person = Person("",20)
    val name: String = person.name  // 직접 접근으로 보이나 내부적으로 getter, setter를 통해 접근이 이루어짐
    person.name = "shin"

    // 위임
    val van: CarModel = CarModel("sportCar", VanType("100"))
    val sportCar: CarModel = CarModel("sportCar", SportCar("100"))

    van.carInfo()
    sportCar.carInfo()


    val a = 5
    val b = 0
    var c: Int
    try {
        c = a/b
    } catch (e: Exception) {
        println("Exception")
        e.printStackTrace()         // 예외의 추적. 예외의 유형과 위치 정보를 알려줌
    } finally {
        println("finally")
    }

    try {
        if (a < 10) throw Exception("5보다 작습니다.")
    } catch (e: Exception) {
        print(e.message)
    }
    println(a)



}