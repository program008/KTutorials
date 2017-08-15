package kotlin_for_android_developers

import java.util.*

/**
 * Copyright (c) 2017 The Android(kotlin) Open Source Project All rights reserved.
 *
 * Created by tao.liu on 2017/8/15
 *
 * 数据类
 */
fun main(args: Array<String>) {

    method_3()
}

data class Forecast(val date: Date, val temperature: Float, val details: String)

private fun method_1() {
    val f1 = Forecast(Date(), 27.5f, "Shiny day")
    val f2 = f1.copy(temperature = 30f)
    println(f1.toString())//Forecast(date=Tue Aug 15 17:24:34 CST 2017, temperature=27.5, details=Shiny day)
    println(f2.toString())//Forecast(date=Tue Aug 15 17:24:34 CST 2017, temperature=30.0, details=Shiny day)
}
/*
 映射对象的属性到变量中，就是我们通常所说的多声明。
 这就是为什么会有componentX函数被自动创建。
 使用上面的Forecast类举个例子
 */
private fun method_2(){
    val f1 = Forecast(Date(), 27.5f, "Shiny day")
    val (date, temperature, details) = f1
    println("$date $temperature $details")
}

/*
Map类含有一些扩展函数的实现，允许它在迭代时使用key和value：
 */
private fun method_3(){
    val map = mapOf<Int,String>(1 to "lau",2 to "lambda")
    for ((key, value) in map) {
        println("key:$key, value:$value")
    }
}

