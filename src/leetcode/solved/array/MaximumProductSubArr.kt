package leetcode.solved.array

// 152. Maximum Product Subarray
// Runtime: 200 ms, faster than 35.29%
// Memory Usage: 36.7 MB, less than 20.59%
fun maxProduct(nums: IntArray): Int {
    return product(nums,0)
}

fun product(nums: IntArray, index:Int): Int{
    if(index>nums.lastIndex)
        return Int.MIN_VALUE
    if(nums[index]==0)
        return Math.max(0, product(nums, index+1))
    if(index == nums.lastIndex || nums[index+1]==0)
        return Math.max(nums[index], product(nums, index+1))

    var leftIndex = 0
    var leftSum = 1
    var rightIndex = 0
    var rightSum = 1
    var negativeValues = 0
    var betweenSum = 1
    var maxProduct = nums[index]

    asd@for(i in index..nums.lastIndex){
        when{
            nums[i]<0 -> {
                if(negativeValues==0)
                    leftIndex = i
                else{
                    betweenSum *= Math.abs(rightSum * if(negativeValues>1) nums[rightIndex] else 1)
                    rightIndex = i
                    rightSum = 1
                }
                negativeValues++
            }
            nums[i]>0 -> {
                if(negativeValues==0)
                    leftSum *= nums[i]
                else
                    rightSum *= nums[i]
            }
            nums[i] == 0 -> {
                if (i==index)
                    return Math.max(0, product(nums,i+1))
                maxProduct = Math.max(maxProduct, product(nums, i+1))
                break@asd
            }
        }
    }

    return when{
        negativeValues==0 ->
            Math.max(maxProduct, leftSum*betweenSum*rightSum)
        negativeValues%2==0 ->
            Math.max(maxProduct, leftSum*betweenSum*rightSum*nums[leftIndex]*nums[rightIndex])
        negativeValues == 1 ->
            Math.max(maxProduct, Math.max(leftSum, rightSum))
        else -> {
            if(leftSum*nums[leftIndex] <= rightSum*nums[rightIndex])
                Math.max(maxProduct, (-1)*betweenSum*leftSum*nums[leftIndex])
            else
                Math.max(maxProduct, (-1)*betweenSum*rightSum*nums[rightIndex])
        }
    }
}

fun main(){
    print(maxProduct(intArrayOf(-2,0,-3,1)))
}