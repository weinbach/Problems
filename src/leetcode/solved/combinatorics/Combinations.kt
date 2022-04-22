package leetcode.solved.combinatorics

import java.util.*

// 77. Combinations
// Runtime: 817 ms, faster than 10.76%
// Memory Usage: 181.3 MB, less than 5.38%
val res = LinkedList<List<Int>>()
fun combine(n: Int, k: Int): List<List<Int>> {
    val nums = Array(n){it+1}

    makePermutations(nums, k, LinkedList(), 0)
    return res
}

fun makePermutations(nums: Array<Int>, permLength: Int, currSequence: LinkedList<Int>, index: Int){
    if(permLength==0){
        res.add(currSequence)
        return
    }

    for(i in index..nums.lastIndex){
        val sequence = LinkedList(currSequence)

        sequence.add(nums[i])
        makePermutations(nums, permLength-1, sequence, i+1)
    }
}

fun main(){
    combine(4, 2)
}