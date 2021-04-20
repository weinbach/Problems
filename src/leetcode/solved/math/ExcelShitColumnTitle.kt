package leetcode.solved.math

// 168. Excel Sheet Column Title
// Runtime: 128 ms, faster than 78.13%
// Memory Usage: 32.7 MB, less than 93.75%
private fun convertToTitle(columnNumber: Int): String {
    var res = ""
    var temp = columnNumber

    while(temp>26){
        var inner = temp%26
        temp /= 26

        if(inner == 0){
            inner = 26
            temp--
        }

        res = "${(64+inner).toChar()}$res"
    }
    res = "${(64+temp).toChar()}$res"
    return res
}

fun main(){
    print(convertToTitle(17576))
    val s = (64+26).toChar()
    //print(s)
}

