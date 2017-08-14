package basics

/**
 * Copyright (c) 2017 The Android(kotlin) Open Source Project All rights reserved.
 *
 * Created by tao.liu on 2017/8/14
 *
 * 类与对象的测试类
 */
fun main(args: Array<String>) {

    method_2()
}

/**
 * 测试接口
 */
private fun method_1() {
    var child = Child()
    child.bar()
    child.foo()

    println(child.name)
}
//-----------------------------------------------------------------------------------------------------------------------
/**
 * 实例中接口 A 和 B 都定义了方法 foo() 和 bar()， 两者都实现了 foo(), B 实现了 bar()。
 * 因为 C 是一个实现了 A 的具体类，所以必须要重写 bar() 并实现这个抽象方法。
 * 然而，如果我们从 A 和 B 派生 D，我们需要实现多个接口继承的所有方法，并指明 D 应该如何实现它们。
 * 这一规则 既适用于继承单个实现（bar()）的方法也适用于继承多个实现（foo()）的方法。
 */
interface A {
    fun foo() {
        println("A foo")
    }

    fun bar()
}

interface B {
    fun foo() {
        println("B foo")
    }

    fun bar() {
        println("B bar")
    }
}

class C : A {
    override fun bar() {
        println("C bar")
    }

}

class D : A, B {
    override fun foo() {
        super<A>.foo()
        super<B>.foo()
    }

    override fun bar() {
        super<B>.bar()
    }

}

private fun method_2() {
    var d = D()
    d.bar()
    d.foo()

    var c = C()
    c.foo()
    c.bar()
}