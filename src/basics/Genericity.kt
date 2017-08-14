package basics

/**
 * Copyright (c) 2017 The Android(kotlin) Open Source Project All rights reserved.
 *
 * Created by tao.liu on 2017/8/14
 *
 * 泛型
 */
fun main(args: Array<String>) {
    method_2()
}

class Box<T>(t: T) {
    var value = t
}

/**
 * 定义泛型类型变量，可以完整地写明类型参数，如果编译器可以自动推定类型参数，也可以省略类型参数。
 * Kotlin 泛型函数的声明与 Java 相同，类型参数要放在函数名的前面：
 */
fun <T> boxIn(value: T) = Box(value)

private fun method_1() {
    var bx: Box<Int> = Box<Int>(2)
    var bx1 = Box(1)// // 编译器会进行类型推断，1 类型 Int，所以编译器知道我们说的是 Box<Int>。

    var bx2 = Box<String>("Lau")

    println("${bx.value}, ${bx1.value}, ${bx2.value}")

    var bx3 = boxIn(1)
    var bx4 = boxIn<Int>(2)

    println("${bx3.value}, ${bx4.value}")
}

fun <T> doPrintln(content: T) {
    when (content) {
        is Int ->  println("$content is int data")
        is String -> println("$content is String of toUpperCase ${content.toUpperCase()}")
        else -> println("$content Type not is Int nor String")
    }
}

private fun method_2(){
    var age = 1
    var name = "Lau"
    var bool = true

    doPrintln(age)
    doPrintln(bool)
    doPrintln(name)
}
/*
默认的上界是 Any?。
对于多个上界约束条件，可以用 where 子句：
 */
//fun <T> cloneWhenGreater(list: List<T>, threshold: T): List<T>
//        where T : Comparable, Cloneable {
//    return list.filter(it -> threshold).map(it.clone())
//}

/*
型变
    Kotlin 中没有通配符类型，它有两个其他的东西：声明处型变（declaration-site variance）与类型投影（type projections）。
    声明处型变
    声明处的类型变异使用协变注解修饰符：in、out，消费者 in, 生产者 out。
    使用 out 使得一个类型参数协变，协变类型参数只能用作输出，可以作为返回值类型但是无法作为入参的类型：
 */

// 定义一个支持协变的类
class Runoob<out A>(val a: A) {
    fun foo(): A {
        return a
    }
}

private fun method_3(){
    var strCo: Runoob<String> = Runoob("a")
    var anyCo: Runoob<Any> = Runoob<Any>("b")
    anyCo = strCo
    println(anyCo.foo())   // 输出 a
}
//in 使得一个类型参数逆变，逆变类型参数只能用作输入，可以作为入参的类型但是无法作为返回值的类型：
// 定义一个支持逆变的类
class Runoob2<in A>(a: A) {
    fun foo(a: A) {
    }
}

private fun method_4(){
    var strDCo = Runoob2("a")
    var anyDCo = Runoob2<Any>("b")
    strDCo = anyDCo
}

/*
星号投射
有些时候, 你可能想表示你并不知道类型参数的任何信息, 但是仍然希望能够安全地使用它. 这里所谓"安全地使用"是指,
对泛型类型定义一个类型投射, 要求这个泛型类型的所有的实体实例, 都是这个投射的子类型。
对于这个问题, Kotlin 提供了一种语法, 称为 星号投射(star-projection):
假如类型定义为 Foo<out T> , 其中 T 是一个协变的类型参数, 上界(upper bound)为 TUpper ,Foo<> 等价于 Foo<out TUpper> .
它表示, 当 T 未知时, 你可以安全地从 Foo<> 中 读取TUpper 类型的值.
假如类型定义为 Foo<in T> , 其中 T 是一个反向协变的类型参数, Foo<> 等价于 Foo<inNothing> . 它表示, 当 T 未知时,
你不能安全地向 Foo<> 写入 任何东西.
假如类型定义为 Foo<T> , 其中 T 是一个协变的类型参数, 上界(upper bound)为 TUpper , 对于读取值的场合,
Foo<*> 等价于 Foo<out TUpper> , 对于写入值的场合, 等价于 Foo<in Nothing> .
如果一个泛型类型中存在多个类型参数, 那么每个类型参数都可以单独的投射. 比如,
如果类型定义为interface Function<in T, out U> , 那么可以出现以下几种星号投射:
    Function<*, String> , 代表 Function<in Nothing, String> ;
    Function<Int, *> , 代表 Function<Int, out Any?> ;
    Function<, > , 代表 Function<in Nothing, out Any?> .
注意: 星号投射与 Java 的原生类型(raw type)非常类似, 但可以安全使用
 */