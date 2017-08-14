package basics


/**
 * Copyright (c) 2017 The Android(kotlin) Open Source Project All rights reserved.
 *
 * Created by tao.liu on 2017/8/14
 *
 * Kotlin 扩展
 */

fun main(args: Array<String>) {
    method_9()
}

/**
 * 扩展函数
 * 扩展函数可以在已有类中添加新的方法，不会对原类做修改，扩展函数定义形式：
 * fun receiverType.functionName(params){
 * body
 * }
 * >receiverType：表示函数的接收者，也就是函数扩展的对象
 * >functionName：扩展函数的名称
 * >params：扩展函数的参数，可以为NULL
 */
class User(var name: String)

/**扩展函数**/
fun User.Print() {
    println("用户名$name")
}

private fun method_1() {
    var user = User("Lambda Lau")
    user.Print()
}

//下面代码为 MutableList 添加一个swap 函数：
//this关键字指代接收者对象(receiver object)(也就是调用扩展函数时, 在点号之前指定的对象实例)。
//若扩展函数和成员函数一致，则使用该函数时，会优先使用成员函数。

// 扩展函数 swap,调换不同位置的值
fun MutableList<Int>.swap(index1: Int, index2: Int) {
    var tmp = this[index1] //this 对象类表
    this[index1] = this[index2]
    this[index2] = tmp
}

private fun method_2() {
    var l = mutableListOf<Int>(1, 2, 3)
    // 位置 0 和 2 的值做了互换
    l.swap(0, 2) // 'swap()' 函数内的 'this' 将指向 'l' 的值
    println(l.toString())

}

/*
    扩展函数是静态解析的
    扩展函数是静态解析的，并不是接收者类型的虚拟成员，在调用扩展函数时，具体被调用的的是哪一个函数，
    由调用函数的的对象表达式来决定的，而不是动态的类型决定的:
 */

open class E

class F : E()

fun E.foo() = "E"   // 扩展函数 foo

fun F.foo() = "F"   // 扩展函数 foo

fun printFoo(c: E) {
    println(c.foo())  // 类型是 C 类
}

private fun method_3() {
    printFoo(F())
}


//若扩展函数和成员函数一致，则使用该函数时，会优先使用成员函数。
class Teacher {
    fun foo() {
        println("成员方法")
    }
}

fun Teacher.foo() {
    println("扩展方法")
}

private fun method_4() {
    var t = Teacher()
    t.foo()
}

/*
    扩展一个空对象
    在扩展函数内， 可以通过 this 来判断接收者是否为 NULL,这样，即使接收者为 NULL,也可以调用扩展函数。例如:
 */

fun Any?.toString(): String {
    if (this == null) return "null"
    // 空检测之后，“this”会自动转换为非空类型，所以下面的 toString()
    // 解析为 Any 类的成员函数
    return toString()
}

private fun method_5() {
    var t = null
    println(t.toString())
}

/**
 * 扩展属性允许定义在类或者kotlin文件中，不允许定义在函数中。
 * 初始化属性因为属性没有后端字段（backing field），所以不允许被初始化，
 * 只能由显式提供的 getter/setter 定义。
 *
 * 扩展属性只能被声明为 val。
 */
val <T> List<T>.lastIndex: Int
    get() = size - 1

private fun method_6() {

}

/*
伴生对象的扩展
如果一个类定义有一个伴生对象 ，你也可以为伴生对象定义扩展函数和属性。
伴生对象通过"类名."形式调用伴生对象，伴生对象声明的扩展函数，通过用类名限定符来调用：
 */
class MyClass {
    companion object {// 将被称为 "Companion"
    }
}

fun MyClass.Companion.foo() {
    println("伴生对象的扩展函数")
}

val MyClass.Companion.no: Int
    get() = 10

private fun method_7() {
    println("no: ${MyClass.no}")
    MyClass.foo()
}

/*
    扩展声明为成员
    在一个类内部你可以为另一个类声明扩展。
    在这个扩展中，有个多个隐含的接受者，其中扩展方法定义所在类的实例称为分发接受者，
    而扩展方法的目标类型的实例称为扩展接受者。

    在 C 类内，创建了 D 类的扩展。此时，C 被成为分发接受者，而 D 为扩展接受者。
    从上例中，可以清楚的看到，在扩展函数中，可以调用派发接收者的成员函数。
    假如在调用某一个函数，而该函数在分发接受者和扩展接受者均存在，则以扩展接收者优先，
    要引用分发接收者的成员你可以使用限定的 this 语法。
 */

class D1 {
    fun bar() {
        println("D bar")
    }
}

class C1 {
    fun baz() {
        println("C baz")
    }

    fun bar() {
        println("C bar")
    }

    fun D1.foo() {
        bar()   // 调用 D.bar
        baz()   // 调用 C.baz

        this@C1.bar()  // 调用 C.bar()
    }

    fun caller(d: D1) {
        d.foo()   // 调用扩展函数
    }
}

private fun method_8() {
    var d = D1()
    var c = C1()
    c.caller(d)
}

/*
    ***
    以成员的形式定义的扩展函数, 可以声明为 open , 而且可以在子类中覆盖. 也就是说,
    在这类扩展函数的派 发过程中, 针对分发接受者是虚拟的(virtual), 但针对扩展接受者仍然是静态的。
 */
open class DD {
}

class DD1 : DD() {
}

open class CC {
    open fun DD.foo() {
        println("DD.foo in CC")
    }

    open fun DD1.foo() {
        println("DD1.foo in CC")
    }

    fun caller(d: DD) {
        d.foo()   // 调用扩展函数
    }
}

class CC1 : CC() {
    override fun DD.foo() {
        println("D.foo in C1")
    }

    override fun DD1.foo() {
        println("D1.foo in C1")
    }
}

private fun method_9(){
    CC().caller(DD())   // 输出 "D.foo in C"
    CC1().caller(DD())  // 输出 "D.foo in C1" —— 分发接收者虚拟解析
    CC().caller(DD1())  // 输出 "D.foo in C" —— 扩展接收者静态解析
}