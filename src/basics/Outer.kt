package basics

/**
 * Copyright (c) 2017 The Android(kotlin) Open Source Project All rights reserved.
 *
 * Created by tao.liu on 2017/8/14
 *
 *
 */
class Outer {//外部类
    private var bar: Int = 1

    class Nested {//嵌套类
        fun foo() = 2
    }
}

fun main(args: Array<String>) {
    var outer = Outer();
    //println(outer.bar)
    var nested = Outer.Nested().foo()//// 调用格式：外部类.嵌套类.嵌套类方法/属性
    println(nested)
}