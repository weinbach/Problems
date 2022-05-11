package leetcode.solved.combinatorics

// 2266. Count Number of Texts
// Runtime: 1261 ms, faster than 6.25%
// Memory Usage: 125.3 MB, less than 25.00%
fun countTexts(pressedKeys: String): Int {
    var res: Long = 1

    var i = 0
    while (i <= pressedKeys.lastIndex) {
        var j = i + 1
        var count = 1
        while (j <= pressedKeys.lastIndex && pressedKeys[i] == pressedKeys[j]) {
            count++
            j++
        }
        val key = Character.getNumericValue(pressedKeys[i])
        i = j
        val short = !(key == 7 || key == 9)

        res = (res * (getPermAmount(count, short) % mod)) % mod
    }
    return (res % mod).toInt()
}

const val mod = 1000000007
val shortMap = HashMap<Int, Long>().apply {
    this[1] = 1
    this[2] = 2
    this[3] = 4
    this[4] = 7
}
val longMap = HashMap<Int, Long>().apply {
    this[1] = 1
    this[2] = 2
    this[3] = 4
    this[4] = 8
}

fun getPermAmount(amount: Int, short: Boolean): Long {
    val res = if (short) shortMap else longMap
    if (!res.containsKey(amount)) {
        if (short)
            res[amount] = (getPermAmount(amount - 1, short) +
                    getPermAmount(amount - 2, short) +
                    getPermAmount(amount - 3, short)) % mod
        else
            res[amount] = (getPermAmount(amount - 1, short) +
                    getPermAmount(amount - 2, short) +
                    getPermAmount(amount - 3, short) +
                    getPermAmount(amount - 4, short)) % mod
    }

    return res[amount]!!
}

fun main() {
    print(countTexts("88888888888888888888888888888999999999999999999999999999994444444444444444444444444444488888888888888888888888888888555555555555555555555555555556666666666666666666666666666666666666666666666666666666666222222222222222222222222222226666666666666666666666666666699999999999999999999999999999888888888888888888888888888885555555555555555555555555555577777777777777777777777777777444444444444444444444444444444444444444444444444444444444433333333333333333333333333333555555555555555555555555555556666666666666666666666666666644444444444444444444444444444999999999999999999999999999996666666666666666666666666666655555555555555555555555555555444444444444444444444444444448888888888888888888888888888855555555555555555555555555555555555555555555555555555555555555555555555555555555555999999999999999555555555555555555555555555554444444444444444444444444444444555"))
    //val s: Int = 10609*264048
    //print(s)
}

// 4 -> 32 ; 8 -> 16 ; 9 -> 12; 3 -> 16; 6-> 16; 2->16; 6-> 16; 3->16; 8->16; 2->16; 4->16; 8->13; 2->16; 8->13; 9->16; 3->9; 4->6; 66; 4