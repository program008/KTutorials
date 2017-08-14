package basics

/**
 * Copyright (c) 2017 The Android(kotlin) Open Source Project All rights reserved.
 *
 * Created by tao.liu on 2017/8/14
 *
 *
 */
class Outer2 {
    //内部类会带有一个对外部类的对象的引用，所以内部类可以访问外部类成员属性和成员函数。
    private var bar:Int = 1
    var v = "成员属性"

    /**嵌套内部类**/
    inner class Inner{
        fun foo() = bar
        fun innerTest(){
            var o = this@Outer2 //为了消除歧义，要访问来自外部作用域的 this，我们使用this@label，其中 @label 是一个 代指 this 来源的标签。
            println("内部类可以访问外部类的成员"+o.v)
        }
    }
}

/**
 * 匿名内部类
 * 使用对象表达式来创建匿名内部类：
 */
class Test{
    var v = "成员属性"
    fun setInterFace(test: TestInterFace) {
        test.test()
    }
}

interface TestInterFace {
    fun test()
}

fun main(args: Array<String>) {
    var demo = Outer2().Inner().foo()
    var demo2 = Outer2().Inner().innerTest()
    println("demo = $demo demo2 = $demo2")

    println("-----------分割线---------")

    var test = Test()

    /**
     * 采用对象表达式来创建接口对象，即匿名内部类的实例。
     */
    test.setInterFace(object : TestInterFace {
        override fun test() {
            println("对象表达式创建匿名内部类的实例")
        }
    })
}