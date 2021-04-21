package leetcode.solved.hashTable

// 347. Top K Frequent Elements
// Runtime: 288 ms, faster than 14.00%
// Memory Usage: 40.9 MB, less than 66.67%
fun topKFrequent(nums: IntArray, k: Int): IntArray {
    val map = HashMap<Int, Int>()
    val res = IntArray(k)
    for(i in 0..nums.lastIndex){
        if(map.contains(nums[i])){
            map[nums[i]] = map[nums[i]]!!+1
        } else{
            map[nums[i]] = 1
        }
    }
    val sorted = map.toList().sortedBy { pair -> pair.second }
    for(i in 0 until k){
        res[i] = sorted[sorted.lastIndex-i].first
    }
    return res
}

fun main(){
    topKFrequent(intArrayOf(1,1,1,2,2,3,4), 2)
}