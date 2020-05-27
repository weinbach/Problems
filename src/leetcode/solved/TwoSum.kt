fun main(){
    val res = twoSum(intArrayOf(2,7,11,15), 9)
    print("result is: ${res[0]}, ${res[1]}")
}

fun twoSum(nums: IntArray, target: Int): IntArray {
    val hashMap : HashMap<Int, Int> = HashMap()

    for (i in nums.indices){
        val rest = target - nums[i]
        if(hashMap.containsKey(rest))
            return intArrayOf(hashMap.getValue(rest), i)
        else
            hashMap[nums[i]] = i
    }

    return intArrayOf()
}