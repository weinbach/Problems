package leetcode.solved.array

//303. Range Sum Query - Immutable
private class NumArray(val nums: IntArray) {

    fun sumRange(i: Int, j: Int): Int {
        var res = 0
        for(index in i..j){
            res+=nums[index]
        }
        return res
    }

}

fun main(){
    val sd = NumArray(intArrayOf(-2,0,3,-5,2,-1))
    print(sd.sumRange(0,2))
}