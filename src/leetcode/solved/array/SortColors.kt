package leetcode.solved.array

// 75. Sort Colors
// Runtime: 192 ms, faster than 28.05%
// Memory Usage: 36.2 MB, less than 31.71%
fun sortColors(nums: IntArray): Unit {
    var redAmount = 0
    var whiteAmount = 0
    for(i in 0..nums.lastIndex){
        if(nums[i]==0) redAmount++
        else if(nums[i]==1) whiteAmount++
    }
    for(i in 0 until redAmount){
        nums[i] = 0
    }
    for(i in redAmount until (redAmount+whiteAmount)){
        nums[i] = 1
    }
    for(i in (redAmount+whiteAmount)..nums.lastIndex){
        nums[i] = 2
    }
}

// Runtime: 160 ms, faster than 87.80%
// Memory Usage: 36.4 MB, less than 23.17%
// take in mind that it was 7th submission -> percents suffers
fun sortColorImproved(nums: IntArray){
    var temp: Int
    fun swap(i: Int, j: Int){
        temp = nums[i]
        nums[i] = nums[j]
        nums[j] = temp
    }
    var zero = 0
    var two = nums.lastIndex

    for(i in 0..nums.lastIndex){
        if (i>two || zero>=two)
            break
        outerLoop@ while (nums[i]!=1){
            while(nums[i]==0){
                swap(i, zero++)
                if(i==zero-1)
                    break@outerLoop
            }
            while (nums[i]==2){
                swap(i,two--)
                if (i==two+1)
                    break@outerLoop
            }
        }
    }
}

fun main(){
    val w = intArrayOf(2,0,1)
    sortColorImproved(w)
    val asd = 2
}
