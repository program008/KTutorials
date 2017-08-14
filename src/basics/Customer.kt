package basics

/**
 * Copyright (c) 2017 The Android(kotlin) Open Source Project All rights reserved.
 *
 * Created by tao.liu on 2017/8/14
 *
 *
 */
class Customer constructor(var name: String) {
    val customerKey = name.toUpperCase()
    //如果主构造函数没有任何注解或者可见性修饰符，可以省略这个 constructor 关键字。
    //主构造函数不能包含任何的代码。初始化的代码可以放到以 init 关键字作为前缀的初始化块（initializer blocks）中：

    //与普通属性一样，主构造函数中声明的属性可以是可变的（var）或只读的（val）。

    // 如果构造函数有注解或可见性修饰符，这个 constructor 关键字是必需的，并且这些修饰符在它前面：
    init {
        name = "hello world"
        //logger.info("Customer initialized with value ${name}")
    }

    constructor(name: String, age: Int) : this(name) {
        //次构造函数
    }

}