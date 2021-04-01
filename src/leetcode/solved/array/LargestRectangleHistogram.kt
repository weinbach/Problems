package leetcode.solved.array

import java.util.*

// 84. Largest Rectangle in Histogram
fun largestRectangleArea(heights: IntArray): Int {
    return findMaxArea(heights, 0, 0)
}

// Time Limit :D 
private fun findMaxArea(heights: IntArray, startIndex: Int, countingHeight: Int): Int{

    var maxArea = heights[startIndex]
    var currArea = maxArea
    var pathDone = 1
    var currHeight = maxArea

    for(i in startIndex+1..heights.lastIndex){

        when{
            heights[i] == 0 -> {
                return if(countingHeight==0 && i<heights.lastIndex){
                    Math.max(maxArea, findMaxArea(heights, i+1, 0))
                } else {
                    maxArea
                }
            }
            currHeight == heights[i] -> {
                currArea += heights[i]
            }

            currHeight > heights[i] -> {
                if(heights[i]<=countingHeight)
                    return maxArea
                currArea = (pathDone+1)*heights[i]
                currHeight = heights[i]
            }

            currHeight < heights[i] -> {
                val greaterHeightArea = findMaxArea(heights, i, currHeight)
                if(greaterHeightArea>maxArea)
                    maxArea = greaterHeightArea
                currArea += currHeight
            }
        }
        if(currArea>maxArea)
            maxArea = currArea
        pathDone++
    }
    return maxArea
}

//Runtime: 648 ms, faster than 10.87%
//Memory Usage: 48.9 MB, less than 72.83%
private fun approachTwo(heights: IntArray): Int{
    val leftIndices = Array(heights.size){0}
    val rightIndices = Array(heights.size){0}

    val stack = Stack<Int>()

    for(i in 0..heights.lastIndex){
        while (stack.isNotEmpty() && heights[stack.peek()]>=heights[i])
            stack.pop()
        if(stack.isEmpty())
            leftIndices[i] = 0
        else
            leftIndices[i] = stack.peek()+1
        stack.push(i)
    }

    stack.clear()
    for (i in heights.lastIndex downTo 0){
        while (stack.isNotEmpty() && heights[stack.peek()]>=heights[i])
            stack.pop()
        if (stack.isEmpty())
            rightIndices[i] = rightIndices.lastIndex
        else
            rightIndices[i] = stack.peek()-1
        stack.push(i)
    }

    var maxArea = 0
    var area = 0
    for(i in 0..heights.lastIndex){
        area = (rightIndices[i] - leftIndices[i] + 1)*heights[i]
        if(maxArea < area)
            maxArea = area
    }

    return maxArea
}

fun main(){
    print(approachTwo(intArrayOf(2,4)))

}