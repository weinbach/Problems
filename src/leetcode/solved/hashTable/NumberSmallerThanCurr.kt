package leetcode.solved.hashTable

// 1365. How Many Numbers Are Smaller Than the Current Number
// Runtime: 220 ms, faster than 42.75%
// Memory Usage: 39.3 MB, less than 14.49%
fun smallerNumbersThanCurrent(nums: IntArray): IntArray {
    val indexes = HashMap<Int, ArrayList<Int>>()
    for(i in 0..nums.lastIndex){
        if(indexes.contains(nums[i])){
            indexes[nums[i]]!!.add(i)
        } else{
            val arr = ArrayList<Int>()
            arr.add(i)
            indexes[nums[i]] = arr
        }
    }

    nums.sort()
    val res = IntArray(nums.size){0}

    var i = 0
    while(i<=res.lastIndex){
        for(j in indexes[nums[i]]!!){
            res[j] = i
        }
        while(i<res.lastIndex && nums[i+1] == nums[i]){
            i++
        }
        i++
    }
    return res
}

fun main(){
    smallerNumbersThanCurrent(intArrayOf(8,1,2,2,3))
}