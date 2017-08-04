package basics

/**
 * Created by tao.liu on 2017/8/3.
 * kotlin 基本类型基
 */
fun main(args: Array<String>) {
    method08()
}

/**
 * 数字
 * 字面常量
 * 数值常量字面值有以下几种:
 *      十进制: 123
 *      Long 类型用大写 L 标记: 123L
 *      十六进制: 0x0F
 *      二进制: 0b00001011
 *      注意: 不支持八进制
 *      Kotlin 同样支持浮点数的常规表示方法:
 *       默认 double：123.5、123.5e10
 *      Float 用 f 或者 F 标记: 123.5f
 */
fun method01() {
    //你可以使用下划线使数字常量更易读：
    val oneMillion = 1_000_000
    val creditCardNumber = 1234_5678_9012_3456L
    val socialSecurityNumber = 999_99_9999L
    val hexBytes = 0xFF_EC_DE_5E
    val bytes = 0b11010010_01101001_10010100_10010010

    print("${oneMillion},\n${creditCardNumber},\n${socialSecurityNumber},\n${hexBytes},\n${bytes}")
    println()
}

/**
 * 表示方式
 */
fun method02() {

    val a: Int = 10000
    println(a === a) // 输出“true”
    val boxedA: Int? = a
    val anotherBoxedA: Int? = a
    //注意数字装箱不必保留同一性:
    println(boxedA === anotherBoxedA) //!!!输出“false”!!!

    //另一方面，它保留了相等性:
    print(boxedA == anotherBoxedA) // 输出“true”
}

/**
 * 显示转换
 */
fun method03() {
    //由于不同的表示方式，较小类型并不是较大类型的子类型。 如果它们是的话，就会出现下述问题：
    // 假想的代码，实际上并不能编译：
    val a: Int? = 1 // 一个装箱的 Int (java.lang.Integer)
    //val b: Long? = a // 隐式转换产生一个装箱的 Long (java.lang.Long)
    //print(a == b) // 惊！这将输出“false”鉴于 Long 的 equals() 检测其他部分也是 Long
    //所以同一性还有相等性都会在所有地方悄无声息地失去

    val b: Byte = 1
    //val i :Int? = b //error

    val i: Int = b.toInt()//显示转换

    /**
     * 每个数字类型支持如下的转换:
     * -toByte(): Byte
     * -toShort(): Short
     * -toInt(): Int
     * -toLong(): Long
     * -toFloat(): Float
     * -toDouble(): Double
     * -toChar(): Char
     */

    //缺乏隐式类型转换并不显著，因为类型会从上下文推断出来，而算术运算会有重载做适当转换
    val l = 102L + 12 //Long + Int =>Long 只能是运算的时候才出现转换不出错

    //val bb:Int = l // error

}

/**
 * 运算
 */
fun method04() {
    //对于位运算，没有特殊字符来表示，而只可用中缀方式调用命名函数
    val x = (1 shl 2) and 0x0000ff00ff
    println(x)
    /**
     * 这是完整的位运算列表（只用于 Int 和 Long）：
     * -shl(bits) – 有符号左移 (Java 的 <<)
     * -shr(bits) – 有符号右移 (Java 的 >>)
     * -ushr(bits) – 无符号右移 (Java 的 >>>)
     * -and(bits) – 位与
     * -or(bits) – 位或
     * -xor(bits) – 位异或
     * -inv() – 位非
     */
}

/**
 * 字符
 */
fun method05() {
    val c: Char = 'c'
//    if(c==1){
//
//    }

    var digitValue = decimalDigitValue('8')
    println(digitValue)

    //当需要可空引用时，像数字、字符会被装箱。装箱操作不会保留同一性

}

fun decimalDigitValue(c: Char) :Int{
    if(c!in '0'..'9')
        throw IllegalArgumentException("Out of range")
    return c.toInt()-'0'.toInt()//显示的转换成数字
}

/**
 * 布尔
 */
fun method06(){

    val b: Boolean = false
    /**
     * 布尔用 Boolean 类型表示，它有两个值：true 和 false。
     * 若需要可空引用布尔会被装箱。
     * 内置的布尔运算有：
     * || - 短路逻辑或
     * && - 短路逻辑与
     * !  - 逻辑非
     */
}

/**
 * 数组
 */
fun method07(){
    //数组的定义
    //1.制定长度
    val fixedSizeArray = arrayOfNulls<Int>(5)

    //2.使用封装操作
    val array = arrayOf(1,3,4,2,5)
    val intArray = intArrayOf(1,3,4,3,4)
    val booleanArray = booleanArrayOf(false,true,false,true,true)
    //.....

    //3.使用闭包进行初始化
    val asc = Array(5,{i->i*2})

    //空数组
    val empty = emptyArray<Int>()//length is 0,empty array

    //修改数组元素
    fixedSizeArray.set(0,25)
    asc[0] = 50

    //访问数组元素
    println(fixedSizeArray[0])
    println(array[3])
    println(intArray.get(2))
    println(booleanArray.get(3))
    println(asc[0])
    // println(empty[1])//Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 1

    //遍历数组元素

    for (i in asc){
        print("$i ")
    }
    println()
    //遍历数组下标
    for (i in booleanArray.indices){
        println("$i-->${booleanArray[i]}")
    }

    //检查下标
    val i:Int = 5
    if (i in asc.indices) { // i>=0 && i<asc.size()
        println("indices:$i")
    }

    //注意: 与 Java 不同的是，Kotlin 中数组是不型变的（invariant）。
    // 这意味着 Kotlin 不让我们把 Array<String> 赋值给 Array<Any>，
    // 以防止可能的运行时失败（但是你可以使用 Array<out Any>, 参见类型投影）。
}

/**
 * 字符串
 */
fun method08(){
    val s = "Hello, world!\n"

    val text = """
    for (c in "foo")
        print(c)
     """

    val text2 = """
    |Tell me and I forget.
    |Teach me and I remember.
    |Involve me and I learn.
    |(Benjamin Franklin)
    """.trimMargin()

    val price = """
    ${'$'}9.99
    """

    println(s)
    println(text.trim())
    println(text2.trimMargin())
    println(price.trim())

}


