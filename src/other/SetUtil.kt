package other

/**
 * Copyright (c) 2017 The Android(kotlin) Open Source Project All rights reserved.
 *
 * Created by tao.liu on 2017/8/14
 *
 * 集合：List、Set、Map
 */

fun main(args: Array<String>) {
    method_4()
}

private fun method_1(){
    val numbers: MutableList<Int> = mutableListOf(1, 2, 3)
    val readOnlyView: List<Int> = numbers
    println(numbers)        // 输出 "[1, 2, 3]"
    numbers.add(4)
    println(readOnlyView)   // 输出 "[1, 2, 3, 4]"
    println(numbers) // 输出 "[1, 2, 3, 4]"
    //readOnlyView.clear()    // -> 不能编译

    val strings = hashSetOf("a", "b", "c", "c")
    println("strings.size = "+strings.size)
}

/*
Kotlin 没有专门的语法结构创建 list 或 set。 要用标准库的方法，如 listOf()、 mutableListOf()、 setOf()、 mutableSetOf()。
 在非性能关键代码中创建 map 可以用一个简单的惯用法来完成：mapOf(a to b, c to d)

注意上面的 readOnlyView 变量（译者注：与对应可变集合变量 numbers）指向相同的底层 list 并会随之改变。
如果一个 list 只存在只读引用，我们可以考虑该集合完全不可变。创建一个这样的集合的一个简单方式如下：
 */
private fun method_2(){
    val items = listOf(1, 2, 3)
}

/*
    目前 listOf 方法是使用 array list 实现的，但是未来可以利用它们知道自己不能变的事实，返回更节约内存的完全不可变的集合类型。
    注意这些类型是协变的。这意味着，你可以把一个 List<Rectangle> 赋值给 List<Shape> 假定 Rectangle 继承自 Shape。
    对于可变集合类型这是不允许的，因为这将导致运行时故障。
    有时你想给调用者返回一个集合在某个特定时间的一个快照, 一个保证不会变的：
 */
class Controller {
    private val _items = mutableListOf<String>()
    val items: List<String> get() = _items.toList()
}

/*
这个 toList 扩展方法只是复制列表项，因此返回的 list 保证永远不会改变。
List 和 set 有很多有用的扩展方法值得熟悉：
 */
private fun method_3(){
    val items = listOf(1, 2, 3, 4)
    items.first() == 1
    items.last() == 4
    var filter = items.filter { it % 2 == 0 }   // 返回 [2, 4]
    println(filter)
    println(items)
    val rwList = mutableListOf(1, 2, 3)
    rwList.requireNoNulls()        // 返回 [1, 2, 3]
    if (rwList.none { it > 6 }) println("No items above 6")  // 输出“No items above 6”
    val item = rwList.firstOrNull()

    println(item)
}

/**
 * …… 以及所有你所期望的实用工具，例如 sort、zip、fold、reduce 等等。
 * Map 遵循同样模式。它们可以容易地实例化和访问，像这样：
 */
private fun method_4(){
    val readWriteMap = hashMapOf("foo" to 1, "bar" to 2)
    println(readWriteMap["foo"])  // 输出“1”
    val snapshot: Map<String, Int> = HashMap(readWriteMap)

    println(snapshot)
}