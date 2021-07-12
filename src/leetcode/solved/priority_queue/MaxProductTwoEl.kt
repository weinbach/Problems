package leetcode.solved.priority_queue

import java.util.*

//1464. Maximum Product of Two Elements in an Array
// Runtime: 220 ms, faster than 14.29%
// Memory Usage: 37.6 MB, less than 19.05%
fun maxProduct(nums: IntArray): Int {
    val heap = PriorityQueue<Int> { o1, o2 ->
        val res: Int = when {
            o1 > o2 -> -1
            o1 < o2 -> 1
            else -> 0
        }
        res
    }
    for (i in 0..nums.lastIndex)
        heap.add(nums[i])
    return (heap.poll()-1)*(heap.poll()-1)
}

fun main(){
    maxProduct(intArrayOf(3,4,5,2))
}