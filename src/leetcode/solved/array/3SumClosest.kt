package leetcode.solved.array

// 16. 3Sum Closest
// Runtime: 204 ms, faster than 60.81%
// Memory Usage: 36.2 MB, less than 85.13%
fun threeSumClosest(nums: IntArray, target: Int): Int {
    var closest = nums[0]+nums[1]+nums[2]

    for(i in 0..nums.lastIndex){
        for(j in i+1..nums.lastIndex){
            for(k in j+1..nums.lastIndex){
                if(Math.abs(nums[i]+nums[j]+nums[k]-target)<Math.abs(closest-target)){
                    closest = nums[i]+nums[j]+nums[k]
                    if(closest==target)
                        return target
                }
            }
        }
    }
    return closest
}