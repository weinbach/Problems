package leetcode.solved.math

//836. Rectangle Overlap

//Runtime: 132 ms, faster than 57.14%
//Memory Usage: 32.6 MB, less than 14.29%
fun isRectangleOverlap(rec1: IntArray, rec2: IntArray): Boolean {
    val left = rec1[0]<rec2[0]
    val leftRect = if(left) rec1 else rec2
    val rightRect = if(left) rec2 else rec1

    if(rightRect[0]>=leftRect[2])
        return false

    val lower = rec1[1]<rec2[1]
    val botRect = if(lower) rec1 else rec2
    val topRect = if(lower) rec2 else rec1

    if(botRect[3]<=topRect[1]){
        return false
    }

    return true

}
