package sorts

// Performance O(n^2), n^2 comparisons, n swaps
// Space Complexity O(1), no extra space; In place swaps
fun selectionSort(array: IntArray){
    for(i in 0 until array.size-1){
        var minIndex = i
        for(j in i+1 until array.size){
            if(array[minIndex]>array[j])
                minIndex = j
        }
        val temp = array[i]
        array[i] = array[minIndex]
        array[minIndex] = temp
    }
}

fun main(){
    val array = intArrayOf(9,2,7,3,5,0,-1,248,15,12,13,1,1,9)
    selectionSort(array)
    array
}