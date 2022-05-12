package leetcode.solved.combinatorics

// 1641. Count Sorted Vowel Strings
// Runtime: 201 ms, faster than 57.14%
// Memory Usage: 33.5 MB, less than 52.38%
val re = HashMap<Int, Int>().apply{
    this[1] = 15 // a__ all prev sum
    this[2] = 10 // b__ (2 3 4 5)
    this[3] = 6 // c__ (3 4 5)
    this[4] = 3 // d__ (4 5)
    this[5] = 1 // e__ (5)
}

fun countVowelStrings(n: Int): Int {
    if(n == 1) return 5
    if(n == 2) return 15

    var count = 2
    while (count<n)
        calculate(++count)

    return re[1]!!
}

fun calculate(n: Int){
    val four = re[4]!! + 1
    val three = four + re[3]!!
    val two = three + re[2]!!
    val one = two + re[1]!!

    re[1] = one
    re[2] = two
    re[3] = three
    re[4] = four
}

fun main(){
    print( countVowelStrings(6))
}