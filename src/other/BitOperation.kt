package other

/**
 * Copyright (c) 2017 The Android(kotlin) Open Source Project All rights reserved.
 *
 * Created by tao.liu on 2017/8/12
 *
 *
 */

fun main(args: Array<String>) {
    var multiplication = multiplication(9, 16)
    println(multiplication)
}

/**
 * 乘法2*8 => 2<<3 转成位运算
 */
fun multiplication(a: Int, b: Int): Int {
    var i = log2(b*1.0).toInt()
    println("i = "+i)
    if (b % 2 == 0) {
        return a shl i
    } else {
        return (a shl (i+1)) +1
    }
}
/**
 * 除法8*4 => 8>>2 转成位运算
 */
fun division(a:Int,b:Int):Int{
    var i = log2(b*1.0).toInt()
    if (b % 2 == 0) {
        return a shr i
    } else {
        return a shr (i-1) +2
    }
}

/**
 * 指定指定的对数
 */
fun log(value: Double, base: Double): Double {
    return Math.log(value) / Math.log(base)
}

/**
 * 以2为底的对数
 */
fun log2(value: Double):Double{
    return log(value,2.0);
}

/**
 * 以10为底的对数
 */
fun log10(value: Double):Double{
    return log(value,10.0)
}