package other

/**
 * Copyright (c) 2017 The Android(kotlin) Open Source Project All rights reserved.
 *
 * Created by tao.liu on 2017/8/15
 *
 * 区间
 */
fun main(args: Array<String>) {
    method_2()
}

/*
    区间表达式由具有操作符形式 .. 的 rangeTo 函数辅以 in 和 !in 形成。
    区间是为任何可比较类型定义的，但对于整型原生类型，它有一个优化的实现。以下是使用区间的一些示例
 */
private fun method_1() {
    var i: Int = 1
    if (i in 1..10) { // 等同于 1 <= i && i <= 10
        println(i)
    }
    //整型区间（IntRange、 LongRange、 CharRange）有一个额外的特性：它们可以迭代。
    // 编译器负责将其转换为类似 Java 的基于索引的 for-循环而无额外开销。
    for (i in 1..4) print(i) // 输出“1234”
    for (i in 4..1) print(i) // 什么都不输出


    println()
    //如果你想倒序迭代数字呢？也很简单。你可以使用标准库中定义的 downTo() 函数
    for (i in 4 downTo 1) print(i) // 输出“4321”

    println()
    //能否以不等于 1 的任意步长迭代数字？ 当然没问题， step() 函数有助于此
    for (i in 1..4 step 2) print(i) // 输出“13”
    println()
    for (i in 4 downTo 1 step 2) print(i) // 输出“42”

    println()
    //要创建一个不包括其结束元素的区间，可以使用 until 函数：
    for (i in 1 until 10) {   // i in [1, 10) 排除了 10
        print(i)
    }

}

/*
“不安全的”转换操作符
    通常，如果转换是不可能的，转换操作符会抛出一个异常。因此，我们称之为不安全的。
    Kotlin 中的不安全转换由中缀操作符 as（参见operator precedence）完成：
        val x: String = y as String

    请注意，null 不能转换为 String 因该类型不是可空的， 即如果 y 为空，上面的代码会抛出一个异常。
    为了匹配 Java 转换语义，我们必须在转换右边有可空类型，就像：
        val x: String? = y as String?

“安全的”（可空）转换操作符
    为了避免抛出异常，可以使用安全转换操作符 as?，它可以在失败时返回 null：
        val x: String? = y as? String
    请注意，尽管事实上 as? 的右边是一个非空类型的 String，但是其转换的结果是可空的。
 */
private fun method_2(){
    val y = null
    //val x: String = y as String//Exception in thread "main" kotlin.TypeCastException: null cannot be cast to non-null type kotlin.String


    val x2: String? = y as String?

    val x3: String? = y as? String

    println(" $x2 , $x3")
}