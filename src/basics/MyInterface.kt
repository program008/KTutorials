package basics

/**
 * Copyright (c) 2017 The Android(kotlin) Open Source Project All rights reserved.
 *
 * Created by tao.liu on 2017/8/14
 *
 * kotlin 接口
 */
/**
 * Kotlin 接口与 Java 8 类似，使用 interface 关键字定义接口，允许方法有默认实现：
 */
interface MyInterface {
    var name:String //name属性 抽象的
    fun bar()//未实现
    fun foo(){//已实现
        // 可选的方法体
        println("foo")
    }
}