package basics

/**
 * Copyright (c) 2017 The Android(kotlin) Open Source Project All rights reserved.
 *
 * Created by tao.liu on 2017/8/14
 *
 *
 */
/**
 * 个类或者对象可以实现一个或多个接口
 */
class Child() :MyInterface {
    override var name: String = "属性值"//重载属性
    override fun bar() {
        //方法体
        println("bar()")
    }
}