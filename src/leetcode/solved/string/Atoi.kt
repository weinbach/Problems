package leetcode.solved.string

//8. String to Integer (atoi)

//Runtime: 172 ms, faster than 82.99%
//Memory Usage: 35 MB, less than 33.50%
fun myAtoi(str: String): Int {
    if(str.isEmpty())
        return 0

    var start = 0
    var end = 0
    var hasSign = false
    var sign = '+'

    while (str[start]==' '){
        start++
        if(start==str.length)
            return 0
    }

    if(str[start] == '+' || str[start] == '-'){
        hasSign = true
        sign = str[start]
        start++
    }

    end = start
    while (end<str.length && str[end].isDigit())
        end++
    if (start == end)
        return 0
    while (str[start]=='0'){
        start++
        if (start==end)
            return 0
    }
    when{
        end-start>10 -> return if (hasSign && str[start-1]=='-') Int.MIN_VALUE else Int.MAX_VALUE
        end - start == 10 -> {
            return if (hasSign && sign == '-'){
                val num = "$sign${str.substring(start, end)}".toLong()
                if (num<Int.MIN_VALUE)
                    Int.MIN_VALUE
                else
                    num.toInt()
            } else{
                val num = str.substring(start, end).toLong()
                if(num>Int.MAX_VALUE)
                    Int.MAX_VALUE
                else
                    num.toInt()
            }
        }
        else -> return if (hasSign) "$sign${str.substring(start, end)}".toInt() else str.substring(start, end).toInt()
    }
}

fun main(){

    print(myAtoi("-000000000000001"))
}