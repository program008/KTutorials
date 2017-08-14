package basics

/**
 * Copyright (c) 2017 The Android(kotlin) Open Source Project All rights reserved.
 *
 * Created by tao.liu on 2017/8/14
 *
 * 函数与lambda表达式
 */
fun main(args: Array<String>) {
    //var i = double(1)
    method_2()

}

/**
 * 函数声明
 * Kotlin 中的函数使用 fun 关键字声明
 */
fun double(x: Int): Int {
    return 2 * x
}

/*
中缀表示法

函数还可以用中缀表示法调用，当

他们是成员函数或扩展函数
他们只有一个参数
他们用 infix 关键字标注
 */

// 给 Int 定义扩展
infix fun Int.shl(x: Int): Int {
    return x * 2
}

private fun method_1() {
    // 用中缀表示法调用扩展函数

    1 shl 2

    // 等同于这样

    1.shl(2)

    println(1.shl(2))
}

//当函数返回单个表达式时，可以省略花括号并且在 = 符号之后指定代码体即可
fun double2(x: Int): Int = x * 2

//当返回值类型可由编译器推断时，显式声明返回类型是可选的
fun double3(x: Int) = x * 2

//可变数量的参数（Varargs）
//
//函数的参数（通常是最后一个）可以用 vararg 修饰符标记：

fun <T> asList(vararg ts: T): List<T> {
    val result = ArrayList<T>()
    for (t in ts) // ts is an Array
        result.add(t)
    return result
}

private fun method_2() {
    val list = asList(1, 2, 3)

    /*
    在函数内部，类型 T 的 vararg 参数的可见方式是作为 T 数组，即上例中的 ts 变量具有类型 Array <out T>。
    只有一个参数可以标注为 vararg。如果 vararg 参数不是列表中的最后一个参数， 可以使用命名参数语法传递其后的参数的值，
    或者，如果参数具有函数类型，则通过在括号外部传一个 lambda。
    当我们调用 vararg-函数时，我们可以一个接一个地传参，例如 asList(1, 2, 3)，
    或者，如果我们已经有一个数组并希望将其内容传给该函数，我们使用伸展（spread）操作符（在数组前面加 *）：
     */
    val a = arrayOf(1, 2, 3)
    val list2 = asList(-1, 0, *a, 4)

    println(list)
    println(list2)
}

//泛型函数
fun <T> singletonList(item: T): List<T> {
    // ……
    return ArrayList()
}

/*
尾递归函数

Kotlin 支持一种称为尾递归的函数式编程风格。 这允许一些通常用循环写的算法改用递归函数来写，而无堆栈溢出的风险。
当一个函数用 tailrec 修饰符标记并满足所需的形式时，编译器会优化该递归，留下一个快速而高效的基于循环的版本。
 */
tailrec fun findFixPoint(x: Double = 1.0): Double
        = if (x == Math.cos(x)) x else findFixPoint(Math.cos(x))

/*
这段代码计算余弦的不动点（fixpoint of cosine），这是一个数学常数。
它只是重复地从 1.0 开始调用 Math.cos，直到结果不再改变，产生0.7390851332151607的结果。
最终代码相当于这种更传统风格的代码：
 */
private fun findFixPoint(): Double {
    var x = 1.0
    while (true) {
        val y = Math.cos(x)
        if (x == y) return y
        x = y
    }
}
/*
要符合 tailrec 修饰符的条件的话，函数必须将其自身调用作为它执行的最后一个操作。
在递归调用后有更多代码时，不能使用尾递归，并且不能用在 try/catch/finally 块中。
目前尾部递归只在 JVM 后端中支持。
 */




