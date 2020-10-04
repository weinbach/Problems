package leetcode.solved.math

//12. Integer to Roman

//Runtime: 192 ms, faster than 86.59%
//Memory Usage: 36.2 MB, less than 53.66%
fun intToRoman(num: Int): String {
    var str = ""

    var index = 0
    var value = num

    val hash = HashMap<Int, CharArray>()
    hash[0] = charArrayOf('I', 'V', 'X')
    hash[1] = charArrayOf('X', 'L', 'C')
    hash[2] = charArrayOf('C', 'D', 'M')
    hash[3] = charArrayOf('M')

    while (value > 0) {
        val temp = value % 10
        value /= 10
        when {
            temp <= 3 -> {
                for (i in 1..temp)
                    str = "${hash[index]!![0]}$str"
            }
            temp == 4 -> str = "${hash[index]!![0]}${hash[index]!![1]}$str"
            temp == 5 -> str = "${hash[index]!![1]}$str"
            temp <= 8 -> {
                for (i in 6..temp)
                    str = "${hash[index]!![0]}$str"
                str = "${hash[index]!![1]}$str"
            }
            temp == 9 -> str = "${hash[index]!![0]}${hash[index]!![2]}$str"
        }
        index++
    }

    return str
}

fun main(){
    print(intToRoman(58))
}