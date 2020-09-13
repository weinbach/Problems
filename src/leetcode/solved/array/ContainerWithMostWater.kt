package leetcode.solved.array

import kotlin.math.min

//11. Container With Most Water
//Runtime: 508 ms, faster than 24.34%
//Memory Usage: 36.7 MB, less than 34.92%
fun maxArea(height: IntArray): Int {
    var maxArea = 0
    for (i in height.indices){
        for(j in i+1 until height.size){
            val area: Int = (j-i)* min(height[j], height[i])
            if(area>maxArea)
                maxArea = area
        }
    }
    return maxArea
}

fun main(){
    print(maxArea(intArrayOf(1,8,6,2,5,4,8,3,7)))
}