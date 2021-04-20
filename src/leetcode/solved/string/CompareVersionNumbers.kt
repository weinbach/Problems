package leetcode.solved.string

// 165. Compare Version Numbers
// Runtime: 148 ms, faster than 90.63%
// Memory Usage: 35.4 MB, less than 65.63%
fun compareVersion(version1: String, version2: String): Int {
    return check(0, 0, version1, version2)
}

private fun check(first: Int, second: Int, version1: String, version2: String): Int {
    var one = first
    var two = second

    if (one > version1.lastIndex && two > version2.lastIndex)
        return 0

    while (one <= version1.lastIndex && version1[one] == '0')
        one++
    var oneEnd = if (one >= version1.lastIndex + 1 || version1[one] == '.') one else one + 1
    while (oneEnd <= version1.lastIndex && version1[oneEnd] != '.')
        oneEnd++

    while (two <= version2.lastIndex && version2[two] == '0')
        two++
    var twoEnd = if (two >= version2.lastIndex + 1 || version2[two] == '.') two else two + 1
    while (twoEnd <= version2.lastIndex && version2[twoEnd] != '.')
        twoEnd++

    val numOne = if (one == oneEnd) 0 else version1.substring(one, oneEnd).toInt()
    val numTwo = if (two == twoEnd) 0 else version2.substring(two, twoEnd).toInt()

    return when {
        numOne > numTwo -> 1
        numOne < numTwo -> -1
        else -> {
            check(oneEnd + 1, twoEnd + 1, version1, version2)
        }
    }
}

fun main() {
    print(compareVersion("1.0", "1.0.0.0.0"))
}