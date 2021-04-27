package leetcode.solved.binarySearch

// 875. Koko Eating Bananas
// Runtime: 260 ms, faster than 73.81%
// Memory Usage: 38.8 MB, less than 38.10%
fun minEatingSpeed(piles: IntArray, hours: Int): Int {
    if(hours < piles.size)
        return -1
    if(piles.size==1){
        return if(piles[0]/hours == 0 ) 1 else if(piles[0]%hours>0) piles[0]/hours+1 else piles[0]/hours
    }
    var max = Int.MIN_VALUE

    for(i in 0..piles.lastIndex){
        if(piles[i]>max)
            max = piles[i]
    }
    if(hours == piles.size)
        return max

    return customBinarySearch(1, max, piles, hours)
}

fun customBinarySearch(left: Int, right: Int, piles: IntArray, hours: Int): Int{
    if(left>right)
        return -1
    val middle = left + (-left+right)/2
    var iterations = 0

    for( i in 0..piles.lastIndex){
        val goGreater = piles[i]%middle
        iterations += if(piles[i]/middle == 0 ) 1 else if(goGreater>0) piles[i]/middle+1 else piles[i]/middle

        if(iterations>hours){
            return customBinarySearch(middle+1, right, piles, hours)
        }
    }

    return if(hours >= iterations){
        val leftCheck = customBinarySearch(left, middle -1, piles, hours)
        if(leftCheck!=-1)
            leftCheck
        else
            middle
    }
    else
        customBinarySearch(left, middle -1, piles, hours)
}


fun main(){
    print(minEatingSpeed(intArrayOf(3,6,7,11),8))
}

