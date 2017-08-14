package other


/*
 * Copyright (c) 2017 Program008's Studio
 *
 * All rights reserved.
 *
 * Created on 2017-08-14
 * @author tao.liu
 * @description 
 */

fun main(args: Array<String>) {
    method_4()
}
/*
Kotlin中的集合主要有以下几种：

Iterable--An iterator over a collection or another entity that can be represented as a sequence of elements；

MutableIterable--An iterator over a mutable collection. Provides the ability to remove elements while iterating；

Collection--A generic collection of elements. Methods in this interface support only read-only access to the collection；

MutableCollection--A generic collection of elements that supports adding and removing elements；

List--A generic ordered collection of elements. Methods in this interface support only read-only access to the list；

MutableList--A generic ordered collection of elements that supports adding and removing elements；

Set--A generic unordered collection of elements that does not support duplicate elements；

MutableSet--A generic unordered collection of elements that does not support duplicate elements,
and supports adding and removing elements；

Map--A collection that holds pairs of objects (keys and values) and supports efficiently retrieving the value
corresponding to each key. Map keys are unique; the map holds only one value for each key；

MutableMap--A modifiable collection that holds pairs of objects (keys and values) and supports efficiently retrieving
 the value corresponding to each key. Map keys are unique; the map holds only one value for each key；
 */


/*
Iterable
    Iterable接口是最基本的接口，声明了Kotlin中集合的通用方法。
    fun iterator(): Iterator<T> - 返回该集合的元素的迭代器
 */

/*
MutableIterable
    MutableIterable接口继承于Iterabl接口，并重写了iterator方法，
    从该接口继承的类可以表示为可以被迭代并且支持在迭代期间移除元素的元素序列。
    fun iterator(): MutableIterator<T> - 返回该集合的元素的迭代器
 */

/*
Collection

Collection<E>接口继承于Iterable接口，是集合的通用接口，但仅封装了对集合的只读方法，
如果想添加或者删除集合，需调用MutableCollection接口的方法。

成员属性
    val size: Int - 集合中元素的数量
函数

    isEmpty(): Boolean - 判断集合是否为空
    fun contains(E): Boolean - 判断集合中是否包含某一元素
    fun containsAll(Collection<E>): Boolean - 判断集合中是否包含某一集合
    fun iterator(): Iterator<E> - 返回该只读集合的元素的迭代器
 */

/*
MutableCollection<E>

MutableCollection<E>继承于Iterable<E>,Collection<E>接口,封装了添加或移除集合中元素的方法。

    fun add(E): Boolean - 向集合中添加元素。添加成功，返回ture，否则返回false。
    fun addAll(Collection): Boolean - 向集合中添加一个集合。添加成功，返回ture，否则返回false。
    fun remove(E): Boolean - 移除集合中的元素。移除成功，返回ture，否则返回false。
    fun removeAll(Collection): Boolean - 移除集合中的一个集合。移除成功，返回ture，否则返回false。
    fun retainAll(Collection): Boolean - 判断集合中是否包含一个集合。如果包含，返回ture，否则返回false。
    fun clear(): Unit - 将集合中的元素清空
 */

/*
Set

概述

Set是最简单的一种集合。集合中的对象不按特定的方式排序，并且没有重复对象。

Kotlin没有专门的语法用来创建set,可以使用标准库中的方法, 比如setOf(),mutableSetOf()。

emptySet(): Set - 创建一个空的只读Set
setOf(vararg T): Set - 创建一个只读Set
mutableSetOf(vararg elements): MutableSet - 创建一个可变Set
Set API

查询操作

val size: Int - 集合中元素的数量
fun isEmpty(): Boolean - 判断集合是否为空
fun contains(E): Boolean - 判断集合中是否包含某一元素
fun iterator(): Iterator - 返回该只读集合的元素的迭代器
批量操作

fun containsAll(Collection<E>): Boolean - 判断集合中是否包含某一集合
 */

private fun method_1() {
    val setTea: Set<String> = setOf("E", "F", "B", "C", "A", "D", "F", "B")

    for (item in setTea) {
        print("$item ,")
    }
}

data class Book(var name: String, var page: Int, var author: String) {
    override fun hashCode(): Int {
        return this.name.hashCode()
    }

    override fun equals(other: Any?): Boolean {
        if (other is Book) {
            return this.page == other.page
        }
        return super.equals(other)
    }
}

private fun method_2() {
    val bookA = Book("A", 20, "Jone")
    val bookB = Book("A", 21, "Green")
    val bookC = Book("C", 20, "Mark")
    val bookD = Book("D", 22, "Node")
    val bookE = Book("A", 20, "Blue")

    var setBook = setOf(bookA, bookB, bookC, bookD, bookE)
    println(setBook.size)
    for (item in setBook) {

        println("item:$item , hashCode: ${item.hashCode()}")
    }

}

/*
可变Set

概述

MutableSet接口继承于Set, MutableCollection，对Set的扩展，添加了对元素添加和删除的操作。

常用API：

查询操作

fun iterator(): MutableIterator - 返回集合元素的迭代器
元素操作

fun add(E): Boolean - 向集合中添加元素。添加成功，返回ture，否则返回false。
fun remove(E): Boolean - 移除集合中的元素。移除成功，返回ture，否则返回false。
批量操作

fun addAll(Collection): Boolean - 向集合中添加一个集合。添加成功，返回ture，否则返回false。
fun removeAll(Collection): Boolean - 移除集合中的一个集合。移除成功，返回ture，否则返回false。
retainAll(Collection): Boolean - 判断集合中是否包含一个集合。如果包含，返回ture，否则返回false。
fun clear(): Unit - 将集合中的元素清空
 */

private fun method_3() {
    val bookA = Book("A", 20, "Jone")
    val bookB = Book("A", 21, "Green")
    val bookC = Book("C", 20, "Mark")
    val bookD = Book("D", 22, "Node")
    val bookE = Book("A", 20, "Blue")

    var setMulable = mutableSetOf(bookA, bookB, bookC, bookD, bookE)
    setMulable.add(Book("Add", 20, "Floor"))
    println(setMulable.remove(bookA)) //true
    println(setMulable.remove(bookE)) //false
    for (item in setMulable) {
        println("item:$item , hashCode: ${item.hashCode()}")
    }
}

/*
与Java比较

在Java中，Set接口有两个主要的实现类HashSet和TreeSet：

    HashSet : 该类按照哈希算法来存取集合中的对象，存取速度比较快
    TreeSet : 该类实现了SortedSet接口，能够对集合中的对象进行排序。
    LinkedHashSet：具有HashSet的查询速度，且内部使用链表维护元素的顺序(插入的次序)。
Kotlin并没有HashSet、TreeSet和LinkedHashSet。假如，实际开发过程中，如果用到了这三个中某一个Set,
比如想通过hashCode来存取对象，此时该如何是好呢?鉴于与Java的兼容性，JB大婶们已经为我们，封装了生成HashSet、
TreeSet或者LinkedHashSet的函数，我们可以用Java中的这三个类。

    fun hashSetOf(vararg elements: T): java.util.HashSet
    fun linkedSetOf(vararg elements: T): java.util.LinkedHashSet
    sortedSetOf(comparator: java.util.Comparator, vararg elements: T): java.util.TreeSet
    fun sortedSetOf(vararg elements: T): java.util.TreeSet
 */


/*
List
List的特征是其元素以线性方式存储，集合中可以存放重复对象
List<E>接口继承于Collection<E>接口，元素以线性方式存储，集合中可以存放重复对象。

查询操作

    val size: Int - 集合中元素的数量
    fun isEmpty(): Boolean - 判断集合是否为空
    fun contains(E): Boolean - 判断集合中是否包含某一元素
    fun iterator(): Iterator - 返回该只读集合的元素的迭代器
批量操作

    fun containsAll(Collection<E>): Boolean - 判断集合中是否包含某一集合
索引查询操作

    fun get(Int): E - 查寻集合中某个位置的元素
搜索操作

    fun indexOf(E): Int - 返回列表中指定元素首次出现的索引，如果元素不包含在列表中，则返回-1
    fun lastIndexOf(E): Int - 返回列表中指定元素最后一次出现的索引，如果元素不包含在列表中，则返回-1
迭代器

    fun listIterator(): ListIterator - 返回一个集合的迭代器
    fun listIterator(Int): ListIterator - 从指定位置开始，返回集合的迭代器
    fun subList(fromIndex: Int, toIndex: Int): List - 返回此列表中指定的[fromIndex]（包括）和[toIndex]（不包括）之间的集合
 */

/*
MutableList

MutableList<E>接口继承于List<E>，MutableCollection&ltE>，是对只读集合的扩展，增加了了对集合的添加及删除元素的操作。

修改操作

    fun add(E): Boolean - 向集合中添加元素。添加成功，返回ture，否则返回false。
    fun remove(E): Boolean - 移除集合中的元素。移除成功，返回ture，否则返回false。
批量操作

    fun addAll(Collection): Boolean - 向集合中添加一个集合。添加成功，返回ture，否则返回false。
    fun removeAll(Collection): Boolean - 移除集合中的一个集合。移除成功，返回ture，否则返回false。
    retainAll(Collection): Boolean - 判断集合中是否包含一个集合。如果包含，返回ture，否则返回false。
    fun clear(): Unit - 将集合中的元素清空
索引操作

    fun set(Int, E): E - 用指定的元素替换此列表中指定位置的元素，返回该位置的原元素
    fun add(Int, E): Unit - 在指定位置添加一个元素
    fun removeAt(Int): E - 移除指定索引处的元素
迭代器
    fun listIterator(): MutableListIterator - 返回一个集合的迭代器
    fun listIterator(Int): MutableListIterator - 从指定位置开始，返回集合的迭代器
    fun subList(fromIndex: Int, toIndex: Int): MutableList - 返回此列表中指定的[fromIndex]（包括）和[toIndex]（不包括）之间的集合
 */

private fun method_4() {
    val bookA = Book("A", 20, "Jone")
    val bookB = Book("B", 21, "Green")
    val bookC = Book("C", 22, "Mark")
    val bookD = Book("D", 23, "Node")
    val bookE = Book("E", 24, "Blue")

    val listBook = listOf<Book>(bookA, bookB, bookC, bookD, bookE)

    // 获取位置0处的元素
    listBook.get(0)
    // 获取bookA第一次出现的位置
    var indexOf = listBook.indexOf(bookA)
    // 获取bookA最后一次出现的位置
    var lastIndexOf = listBook.lastIndexOf(bookB)

    //扩展函数foreach
    listBook.forEach (::println )

    //for循环
    for (book in listBook) {
        println(book)
    }

    //迭代器
    var listIterator = listBook.listIterator()
    while (listIterator.hasNext()) {
        println(listIterator.next())
    }

}
//toList
class Controller2 {
    private val _items = mutableListOf<String>()
    val items: List<String> get() = _items.toList()
}

/*
Map

Map是一种把键对象和值对象映射的集合，它的每一个元素都包含一对键对象和值对象。
Map没有继承于Collection接口。从Map集合中检索元素时，只要给出键对象，就会返回对应的值对象。

Kitlin中，与list、set一样的是，Map也分为只读map和可变两种Map。

Kotlin中，创建Map时，需调用标准库中的系列函数，如mapOf(),mutableMapOf()

Entry

    Entry

Pair

    Pair类用来存储两个值，这两个值可以是任何类型的，可以用于任何场景，比如Map,List.

    Pair类有扩展函数 to，可快速创建Pair类的实例。

    infix fun
 */

private fun method_5(){
    val bookA = Book("A", 20, "Jone")
    val bookB = Book("A", 21, "Green")
    val bookC = Book("C", 20, "Mark")
    val bookD = Book("D", 22, "Node")
    val bookE = Book("A", 20, "Blue")

    //基于Pair扩展函数 to
    val map= mapOf<Int, Book>(1 to bookA, 2 to bookB, 3 to bookC, 4 to bookD, 5 to bookE)
    var mapMutable = mutableMapOf(1 to bookA, 2 to bookB, 3 to bookC, 4 to bookD, 5 to bookE)

    //基于Pair
    val mapPair = mapOf(Pair(1, bookA), Pair(2, bookB))

    //创建一个空的Map
    val mapEmpty = emptyMap<Int, Book>()

    val hashMap = hashMapOf(1 to bookA, 2 to bookB)

    val linkedHashMap = linkedMapOf(1 to bookA, 2 to bookB)


    //var mapMutable = mutableMapOf(1 to bookA, 2 to bookB, 3 to bookC, 4 to bookD, 5 to bookE)
    val size = mapMutable.size // size = 5

    //Map元素中Key的集合
    val setKey = map.keys
    setKey.forEach(::print) // Log: 1,2,3,4,5

    var setMutableKey = mapMutable.keys
    setMutableKey.forEach(::print) // Log: 1,2,3,4,5


    val setValues = map.values
    setValues.forEach(::println)

    var setMutableValues = mapMutable.values
    setMutableValues.forEach(::println)

    //Map中元素的键/值对的集合
    val setEntry = map.entries
    setEntry.forEach{
        println("key: ${it.key} , value: ${it.value}")
    }

    var setMutableEntry = mapMutable.entries
    setMutableEntry.forEach{
        println("key: ${it.key} , value: ${it.value}")
    }
}

