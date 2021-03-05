package leetcode.solved.array

//27. Remove Element
//Runtime: 188 ms, faster than 25.11%
//Memory Usage: 36.3 MB, less than 9.13%
private fun removeElement(nums: IntArray, value: Int): Int {

    var left = 0
    var right = nums.lastIndex

    while(left<=right){
        if(nums[left]==value){
            while(nums[right]==value){
                if(right==left)
                    return left
                right--
            }
            nums[left] = nums[right]
            right--
            left++
        }
        else
            left++
    }
    return left

}

fun correctName(name: String): String {
    val str = CharArray(name.length)

    str[0] = name[0].toUpperCase()
    for (i in 1..name.lastIndex)
        str[i] = name[i].toLowerCase()

    return String(str)
}

fun main(){
    val sd = correctName("aWesOmE")
    val s = 2
}