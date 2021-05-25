package leetcode.solved.math

import java.lang.StringBuilder

// 43. Multiply Strings
// Runtime: 232 ms, faster than 23.53%
// Memory Usage: 36.2 MB, less than 52.94%
fun multiply(num1: String, num2: String): String {
    var tempProduct: Int
    var index: Int

    if(num1 == "0" || num2 == "0")
        return "0"

    if(num1 == "1")
        return num2
    if(num2 == "1")
        return num1

    val res = StringBuilder(num1.length+num2.length)
    for(i in 0 until res.capacity()){
        res.append("0")
    }

    for(i in num2.lastIndex downTo 0){
        var carry = 0
        for(j in num1.lastIndex downTo 0){
            index = res.capacity()-1-(num2.lastIndex-i)-(num1.lastIndex-j)

            tempProduct = Character.getNumericValue(num2[i])*Character.getNumericValue(num1[j]) + carry + Character.getNumericValue(res[index])
            carry = tempProduct/10
            tempProduct %= 10
            res[index] = (tempProduct+48).toChar()
        }
        if(carry>0)
            res[res.lastIndex-(num2.lastIndex-i)-num1.lastIndex-1] = (carry+48).toChar()
    }
    if(res[0] == '0')
        res.deleteCharAt(0)
    return res.toString()
}

/*
    123
    ^
    456
     ^

    738
   615
  492

    00008

    56088
*/

fun main(){

    val s = "055"
    print(multiply("123", "456"))

}
