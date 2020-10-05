package leetcode.solved.math

//13. Roman to Integer

//Runtime: 228 ms, faster than 46.30%
//Memory Usage: 36.4 MB, less than 24.51%
fun romanToInt(s: String): Int {
    var res = 0.0
    val arr = arrayOf(
            charArrayOf('I', 'V', 'X'),
            charArrayOf('X', 'L', 'C'),
            charArrayOf('C', 'D', 'M'),
            charArrayOf('M'))

    var power = 0
    var i = s.length - 1
    while (i >= 0 && power<4) {
        val unit = arr[power][0]
        val middle = if (power == 3) ' ' else arr[power][1]
        val nextUnit = if (power == 3) ' ' else arr[power][2]

        var inner = i - 1
        if (power == 3)
            inner = -1
        else {
            while (inner >= 0 && (s[inner]==arr[power][0] || s[inner]==arr[power][1])) {
                inner--
            }
            if (inner+1 == i && !(s[i]==arr[power][0] || s[i]==arr[power][1])){
                power++
                continue
            }
        }
        when (s.substring(inner + 1, i + 1)) {
            "$unit" -> res += 1 * Math.pow(10.0, power.toDouble())
            "$unit$unit" -> res += 2 * Math.pow(10.0, power.toDouble())
            "$unit$unit$unit" -> res += 3 * Math.pow(10.0, power.toDouble())
            "$unit$middle" -> res += 4 * Math.pow(10.0, power.toDouble())
            "$middle" -> res += 5 * Math.pow(10.0, power.toDouble())
            "$middle$unit" -> res += 6 * Math.pow(10.0, power.toDouble())
            "$middle$unit$unit" -> res += 7 * Math.pow(10.0, power.toDouble())
            "$middle$unit$unit$unit" -> res += 8 * Math.pow(10.0, power.toDouble())
            "$unit$nextUnit" -> res += 9 * Math.pow(10.0, power.toDouble())
        }
        i = inner
        power++
    }
    return res.toInt()
}

// I II III IV V VI VII VIII IX
// X XX XXX XL L LX LXX LXXX XC
// C CC CCC CD D DC DCC DCCC CM
// M MM MMM

fun main() {
    print(romanToInt("MMMCDIII"))
}
