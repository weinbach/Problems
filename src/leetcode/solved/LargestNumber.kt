package leetcode.solved

// 179. Largest Number
// Runtime: 224 ms, faster than 32.35%
// Memory Usage: 38.2 MB, less than 17.65%
fun largestNumber(nums: IntArray): String {
    val comporator = Comparator<Int> { a, b ->
        var indexOne = 0
        var indexTwo = 0

        val strOne = a.toString()
        val strTwo = b.toString()

        var res = 0
        var toContinue = true

        while (indexOne <= strOne.lastIndex && indexTwo <= strTwo.lastIndex) {
            if (strOne[indexOne] > strTwo[indexTwo]) {
                res = 1
                toContinue = false
                break
            } else if (strOne[indexOne] < strTwo[indexTwo]) {
                res = -1
                toContinue = false
                break
            }
            indexOne++
            indexTwo++
        }

        if (toContinue && (indexOne <= strOne.lastIndex || indexTwo <= strTwo.lastIndex)) {
            res = if (indexOne <= strOne.lastIndex) {
                when {
                    strOne[indexOne] > strTwo[0] -> 1
                    strOne[indexOne] < strTwo[0] -> -1
                    else -> {
                        if("$strOne$strTwo".toDouble()>"$strTwo$strOne".toDouble())
                            1
                        else
                            -1
                    }
                }
            } else {
                when {
                    strTwo[indexTwo] > strOne[0] -> -1
                    strTwo[indexTwo] < strOne[0] -> 1
                    else -> {
                        if("$strOne$strTwo".toDouble()>"$strTwo$strOne".toDouble())
                            1
                        else
                            -1
                    }
                }
            }
        }
        res
    }
    val sortedValues = nums.sortedWith(comporator)

    var res = ""
    if (sortedValues.last() == 0){
        return "0"
    }
    for (i in sortedValues.lastIndex downTo 0) {
        res = "$res${(sortedValues[i])}"
    }
    return res
}


fun main() {
    print(largestNumber(intArrayOf(999999991,9)))
}