package basics

/**
 * Copyright (c) 2017 The Android(kotlin) Open Source Project All rights reserved.
 *
 * Created by tao.liu on 2017/8/14
 *
 * 返回和跳转
 */

fun main(args: Array<String>) {
    method2()
}

fun method1(){
//    Kotlin 有三种结构化跳转表达式：
//
//    return。默认从最直接包围它的函数或者匿名函数返回。
//    break。终止最直接包围它的循环。
//    continue。继续下一次最直接包围它的循环。
//    所有这些表达式都可以用作更大表达式的一部分：

    //val s = person.name ?: return
}

/**
 * break 和continue 标签
 */
fun method2(){
    //标签限制的 break 跳转到刚好位于该标签指定的循环后面的执行点。 continue 继续标签指定的循环的下一次迭代。
    loop@ for (i in 1..100){
        for (j in 1..100){
            if (j%2==0)continue
            if(i>j)break@loop
            println("i =$i j=$j")
        }
    }
}

