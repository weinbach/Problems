package leetcode.solved.array

//852. Peak Index in a Mountain Array
fun peakIndexInMountainArray(arr: IntArray): Int {
    return binarySearchPeak(0, arr.lastIndex, arr)
}

fun binarySearchPeak(start: Int, end: Int, arr:IntArray): Int{

    if(start>end)
        return -1

    val middle: Int = (start + end)/2
    if(middle!=0 && arr[middle]>arr[middle-1] && arr[middle] > arr[middle+1])
        return middle
    else{
        if(arr[middle]>arr[middle+1])
            return binarySearchPeak(start, middle-1, arr)
        else
            return binarySearchPeak(middle+1, end, arr)
    }

}

fun main(){
    print(peakIndexInMountainArray(intArrayOf(3,5,3,2,0)))
}