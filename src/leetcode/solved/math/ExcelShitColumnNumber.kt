package leetcode.solved.math

// 171. Excel Sheet Column Number
// Runtime: 164 ms, faster than 60.47%
// Memory Usage: 35.6 MB, less than 23.26%
fun titleToNumber(columnTitle: String): Int {
    var res = 0.0
    for(i in 0..columnTitle.lastIndex){
        res+=Math.pow(26.0, i.toDouble())*(columnTitle[columnTitle.lastIndex-i].toInt()-64.0)
    }
    return res.toInt()
}

fun main(){
    print(titleToNumber("AAA"))
}