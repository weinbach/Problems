package leetcode.solved.array

import sorts.quickSortCustom

//Runtime: 196 ms, faster than 77.63%
//Memory Usage: 35.3 MB, less than 44.74%

//31. Next Permutation
private fun nextPermutation(nums: IntArray): Unit {

    val hashMap = HashMap<Int, Int>()

    fun findPrevSame(elemIndex: Int): Int{
        for(k in nums.lastIndex downTo elemIndex+1){
            if(hashMap[elemIndex] == hashMap[k])
                return k
        }
        return elemIndex
    }

    for(i in nums.size-1 downTo 0){
        for(j in i-1 downTo 0){
            if(nums[i]>nums[j]){
                hashMap[i] = j
                // Diff in One
                if(j == i-1){
                    swap(nums, findPrevSame(i), j)
                    quickSortCustom(nums, j+1, nums.size-1)
                    return
                }
                break
            }
        }
    }

    var maxIndex: Int = hashMap[nums.size-1]?: -1
    for(i in nums.size-1 downTo 0){
        if(hashMap[i]?:-1> maxIndex){
            maxIndex = i
        }
    }

    if (maxIndex>0){
        swap(nums, findPrevSame(maxIndex), hashMap[maxIndex]!!)
        quickSortCustom(nums, 0, nums.size-1)
    }else
        quickSortCustom(nums, 0, nums.size-1)
}

private fun swap(array: IntArray, indexOne: Int, indexTwo: Int){
    val temp = array[indexOne]
    array[indexOne] = array[indexTwo]
    array[indexTwo] = temp
}


fun main(){
    val arr = intArrayOf(4,2,0,2,3,2,0)
    nextPermutation(arr)
    val s = 2

}


