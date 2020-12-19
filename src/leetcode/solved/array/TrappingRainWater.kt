package leetcode.solved.array

//42. Trapping Rain Water

//Runtime: 212 ms, faster than 31.58%
//Memory Usage: 37.1 MB, less than 61.84%
fun trap(height: IntArray): Int {
    if(height.isEmpty() || height.size<3)
        return 0
    for(i in 0..height.lastIndex){
        if (height[i]>0)
            return countWater(i, height)
        else if(i==height.lastIndex)
            return 0
    }
    return 0
}

fun countWater(leftEdge: Int, height: IntArray): Int{
    if(leftEdge==height.lastIndex)
        return 0
    var waterAmount = 0

    var rightEdge = leftEdge+1

    for(i in rightEdge..height.lastIndex){
        if(height[i] >= height[leftEdge]){
            rightEdge = i
            break
        } else if(height[i]>height[rightEdge]){
            rightEdge = i
        }
    }

    val commonHeight = Math.min(height[leftEdge], height[rightEdge])

    for(i in leftEdge+1 until rightEdge){
        waterAmount+=commonHeight-height[i]
    }

    return waterAmount+ countWater(rightEdge, height)
}

fun main(){
    print(trap(intArrayOf(4,1,3,2,1)))
}