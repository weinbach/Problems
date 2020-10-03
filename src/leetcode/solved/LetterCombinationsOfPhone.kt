package leetcode.solved

//17. Letter Combinations of a Phone Number

//Runtime: 168 ms, faster than 85.23%
//Memory Usage: 34.6 MB, less than 73.83%
fun letterCombinations(digits: String): List<String> {
    val hashMap = HashMap<Char, CharArray>()
    hashMap['2'] = charArrayOf('a', 'b', 'c')
    hashMap['3'] = charArrayOf('d', 'e', 'f')
    hashMap['4'] = charArrayOf('g', 'h', 'i')
    hashMap['5'] = charArrayOf('j', 'k', 'l')
    hashMap['6'] = charArrayOf('m', 'n', 'o')
    hashMap['7'] = charArrayOf('p', 'q', 'r', 's')
    hashMap['8'] = charArrayOf('t', 'u', 'v')
    hashMap['9'] = charArrayOf('w', 'x', 'y', 'z')

    val strings = ArrayList<String>()
    if (digits.isEmpty())
        return strings

    for (char in hashMap[digits[0]]!!) {
        strings.add("$char")
    }

    for (char in 1 until digits.length) {
        for (i in 0 until strings.size) {
            val str = strings[i]
            for (charHash in hashMap[digits[char]]!!.indices) {
                if (charHash == 0)
                    strings[i] = "$str${hashMap[digits[char]]!![charHash]}"
                else
                    strings.add("$str${hashMap[digits[char]]!![charHash]}")
            }
        }
    }

    return strings
}

fun main() {
    letterCombinations("23")
}