package leetcode.solved.array

//53.  Maximum Subarray
//Runtime: 244 ms, faster than 19.93%
//Memory Usage: 39.6 MB, less than 15.20%
fun maxSubArray(nums: IntArray): Int {

    var maxSum = nums[0]
    var currMaxSum = nums[0]

    var i = 1
    while(i in 1..nums.lastIndex){
        if(nums[i]>=0)
            currMaxSum = if(currMaxSum<0) nums[i] else currMaxSum + nums[i]
        else{
            val value = Math.max(nums[i], currMaxSum)
            maxSum = if(value>maxSum) value else maxSum

            if(currMaxSum+nums[i]>0)
                currMaxSum += nums[i]
            else if(i!=nums.lastIndex){
                currMaxSum = nums[i+1]
                i++
            }
        }
        i++
    }
    return Math.max(currMaxSum, maxSum)

}

fun main(){
    print(maxSubArray(intArrayOf(-2, 1 ,0, 3, -2, 9)))
}