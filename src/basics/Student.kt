package basics

/**
 * Copyright (c) 2017 The Android(kotlin) Open Source Project All rights reserved.
 *
 * Created by tao.liu on 2017/8/14
 *
 *
 */
class Student(firstName: String, lastName: String, email: String) {
    //需要注意的是，在主构造函数里，可以直接用这些参数变量赋值给类的属性，或者用构造代码块来实现初始化。

    var firstName: String
    var lastName: String
    var email: String

    init {
        this.firstName = firstName
        this.lastName = lastName
        this.email = email
    }

    fun foo() { print("Foo") } // 成员函数

}

fun main(args: Array<String>) {
    var s = Student("zhang","san","123456789@qq.com")
    println(s.email)
    println(s.firstName)
    s.foo()
}