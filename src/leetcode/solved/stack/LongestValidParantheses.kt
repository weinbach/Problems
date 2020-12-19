package leetcode.solved.stack

import java.util.*

//32. Longest Valid Parentheses

//Runtime: 192 ms, faster than 34.48%
//Memory Usage: 37.3 MB, less than 5.17%
fun longestValidParentheses(s: String): Int{

    val array = BooleanArray(s.length)
    val stack = Stack<Int>()

    for(i in 0..s.lastIndex){
        when(s[i]){
            '(' -> {
                stack.push(i)
            }
            ')' -> {
                if(stack.isNotEmpty()){
                    array[i] = true
                    array[stack.pop()] = true
                }
            }
        }
    }

    var bestLength = 0
    var tempLength =0
    for(i in 0..array.lastIndex){
        if (array[i]){
            tempLength++
        } else{
            if(bestLength<tempLength)
                bestLength = tempLength
            tempLength = 0
        }
    }

    return if(bestLength>tempLength) bestLength else tempLength
}

fun main(){

    //print(longestValidParentheses("(()"))

}