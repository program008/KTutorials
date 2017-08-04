package basics

import java.lang.Integer.parseInt

/**
 * Copyright (c) 2017 The Android(kotlin) Open Source Project All rights reserved.
 *
 * Created by tao.liu on 2017/8/4
 */
fun main(args: Array<String>) {
    method_for()
}

/**
 * if 表达式
 */
fun method_if() {
//在 Kotlin 中，if是一个表达式，即它会返回一个值。 因此就不需要三元运算符（条件 ? 然后 : 否则），因为普通的 if 就能胜任这个角色。

    val a: Int = 1
    val b: Int = 2
// 传统用法
    var max = a
    if (a < b) max = b

// With else
    var max1: Int
    if (a > b) {
        max1 = a
    } else {
        max1 = b
    }

// 作为表达式
    val max2 = if (a > b) a else b
    //if的分支可以是代码块，最后的表达式作为该块的值：

    val max3 = if (a > b) {
        print("Choose a")
        a
    } else {
        print("Choose b")
        b
    }

    println("max $max max1 $max1 max2 $max2 max3 $max3")

    //如果你使用 if 作为表达式而不是语句（例如：返回它的值或者把它赋给变量），该表达式需要有 else 分支。
}

/**
 * When 表达式
 */
fun method_when() {
    val x:Int = 2
    when (x) {
        1 -> print("x == 1")
        2 -> print("x == 2")
        else -> { // 注意这个块
            print("x is neither 1 nor 2")
        }
    }

    //如果很多分支需要用相同的方式处理，则可以把多个分支条件放在一起，用逗号分隔：
    when (x) {
        0, 1 -> print("x == 0 or x == 1")
        else -> print("otherwise")
    }

    //我们可以用任意表达式（而不只是常量）作为分支条件
    val s:String = "2"
    when (x) {
        parseInt(s) -> print("s encodes x")
        else -> print("s does not encode x")
    }


    //我们也可以检测一个值在（in）或者不在（!in）一个区间或者集合中：
    val validNumbers = arrayOf(1,3,4,2)
    when (x) {
        in 1..10 -> print("x is in the range")
        in validNumbers -> print("x is valid")
        !in 10..20 -> print("x is outside the range")
        else -> print("none of the above")
    }

    fun hasPrefix(x: Any) = when(x) {
        is String -> x.startsWith("prefix")
        else -> false
    }

//    when {
//        x.isOdd() -> print("x is odd")
//        x.isEven() -> print("x is even")
//        else -> print("x is funny")
//    }
}

/**
 * 循环for
 */
fun method_for(){
    val ints = intArrayOf(10,20,30,40,50,60,70,80,90,100)
    for (item: Int in ints) {
        println(item)
    }

    for (i in ints.indices) {
        print("$i->${ints[i]} ")
    }
    println("-------------------------")
    //注意这种“在区间上遍历”会编译成优化的实现而不会创建额外对象。
    // 或者你可以用库函数 withIndex：
    for ((index, value) in ints.withIndex()) {
        println("the element at $index is $value")
    }

}

/**
 * While 循环
 */
fun method_while(){
    //while 和 do..while 照常使用
    var x:Int = 2
    while (x > 0) {
        x--
    }

    do {
       // val y = retrieveData()
        val y = 32
    } while (y != null) // y 在此处可见
}

