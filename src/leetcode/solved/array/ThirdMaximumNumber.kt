package leetcode.solved.array

//414. Third Maximum Number
//Runtime: 176 ms, faster than 84.00% of Kotlin online submissions for Third Maximum Number.
//Memory Usage: 35.5 MB, less than 6.67% of Kotlin online submissions for Third Maximum Number.

fun thirdMax(nums: IntArray): Int {
    var firstMax: Int? = null
    var secondMax: Int? = null
    var thirdMax: Int? = null

    var iterationVar: Int
    for (i in nums.indices) {
        iterationVar = nums[i]
        when {
            firstMax == null -> firstMax = iterationVar
            iterationVar > firstMax -> {
                thirdMax = secondMax
                secondMax = firstMax
                firstMax = iterationVar
            }

            iterationVar == firstMax -> { }
            secondMax == null -> secondMax = iterationVar
            iterationVar > secondMax -> {
                thirdMax = secondMax
                secondMax = iterationVar
            }

            iterationVar == secondMax -> { }
            thirdMax == null -> thirdMax = iterationVar
            iterationVar > thirdMax -> {
                thirdMax = iterationVar
            }
        }
    }

    return thirdMax ?: firstMax!!
}

fun main() {
    println(thirdMax(intArrayOf(2, 2, 3, 1)))
}