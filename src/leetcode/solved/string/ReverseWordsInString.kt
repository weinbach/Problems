package leetcode.solved.string

import java.util.*

// 151. Reverse Words in a String
// Runtime: 188 ms, faster than 83.54%
// Memory Usage: 36.5 MB, less than 62.03%
fun reverseWords(s: String): String {
    var res = ""
    var startIndex = 0

    outer@ while(startIndex <= s.lastIndex){
        while(startIndex<=s.lastIndex && s[startIndex]==' '){
            if(startIndex == s.lastIndex)
                break@outer
            startIndex++
        }
        val leftIndex = startIndex
        while (startIndex<=s.lastIndex && s[startIndex] != ' ')
            startIndex++

        res = if(res.isEmpty())
            s.substring(leftIndex, startIndex)
        else
            "${s.substring(leftIndex, startIndex)} $res"
    }

    return res
}

fun main(){
    print(reverseWords("  the   "))
}