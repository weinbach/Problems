package sorts

// Performance O(n^2), n^2 comparisons, n^2 swaps
// Space Complexity O(1), no extra space; In place swaps
fun bubbleSort(array: IntArray){
    var end = array.size-1
    for(i in array.indices){
        for(j in 0 until end){
            if(array[j]>array[j+1]){
                val temp = array[j]
                array[j] = array[j+1]
                array[j+1] = temp
            }
        }
        end--
    }
}

fun main(){
    val array = intArrayOf(9,2,7,3,5)
    bubbleSort(array)
}