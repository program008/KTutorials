package basics

/**
 * Copyright (c) 2017 The Android(kotlin) Open Source Project All rights reserved.
 *
 * Created by tao.liu on 2017/8/14
 *
 * 数据类和封装类
 */
fun main(args: Array<String>) {

    method_2()
}

/*
数据类
Kotlin 可以创建一个只包含数据的类，关键字为 data：
data class User(val name: String, val age: Int)
编译器会自动的从主构造函数中根据所有声明的属性提取以下函数：
    equals() / hashCode()
    toString() 格式如 "User(name=John, age=42)"
    componentN() functions 对应于属性，按声明顺序排列
    copy() 函数
如果这些函数在类中已经被明确定义了，或者从超类中继承而来，就不再会生成。
为了保证生成代码的一致性以及有意义，数据类需要满足以下条件：
    主构造函数至少包含一个参数。
    所有的主构造函数的参数必须标识为val 或者 var ;
    数据类不可以声明为 abstract, open, sealed 或者 inner;
    数据类不能继承其他类 (但是可以实现接口)。
 */
data class User1(val name: String, val age: Int)

//使用 copy 类复制 User 数据类，并修改 age 属性:
/**
 * 复制
 * 复制使用 copy() 函数，我们可以使用该函数复制对象并修改部分属性, 对于上文的 User 类，其实现会类似下面这样：
 * fun copy(name: String = this.name, age: Int = this.age) = User(name, age)
 */
private fun method_1() {
    val jake = User1("jake", 1)
    val orderJake = jake.copy(age = 2)

    println(jake)
    println(orderJake)
}

/**
 * 数据类以及解构声明
 * 组件函数允许数据类在解构声明中使用：
 */
private fun method_2() {
    val lau = User1("lau", 26)
    val (name, age) = lau

    println("name = $name,$age years of age")
}
/*
  密封类
    密封类用来表示受限的类继承结构：当一个值为有限集中的类型, 而不能有任何其他类型时。在某种意义上，
    他们是枚举类的扩展：枚举类型的值集合 也是受限的，但每个枚举常量只存在一个实例，而密封类 的一个子类可以有可包含状态的多个实例。
    声明一个密封类，使用 sealed 修饰类，密封类可以有子类，但是所有的子类都必须要内嵌在密封类中。
    sealed 不能修饰 interface ,abstract class(会报 warning,但是不会出现编译错误)
 */
sealed class Expr
data class Const(val number: Double) : Expr()
data class Sum(val e1: Expr, val e2: Expr) : Expr()
object NotANumber : Expr()

fun eval(expr: Expr): Double = when (expr) {
    is Const -> expr.number
    is Sum -> eval(expr.e1) + eval(expr.e2)
    NotANumber -> Double.NaN
}

/**
 * 使用密封类的关键好处在于使用 when 表达式 的时候，如果能够 验证语句覆盖了所有情况，就不需要为该语句再添加一个 else 子句了。
 */
//fun eval(expr: Expr): Double = when(expr) {
//    is Expr.Const -> expr.number
//    is Expr.Sum -> eval(expr.e1) + eval(expr.e2)
//    Expr.NotANumber -> Double.NaN
//// 不再需要 `else` 子句，因为我们已经覆盖了所有的情况
//}


