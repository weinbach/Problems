package sorts

// Performance O(n^2)
// Space Complexity O(1), no extra space; In place swaps
fun insertionSort(array: IntArray){
    for(i in 1 until array.size){
        val curr = array[i]
        for (j in i-1 downTo 0){
            if(curr<array[j]){
                array[j+1] = array[j]
                if(j==0)
                    array[j] = curr
            }
            else{
                array[j+1] = curr
                break
            }
        }
    }
}

fun main(){
    val array = intArrayOf(9,2,7,3,5,0,-1,248,15,12,13,1,1,9)
    insertionSort(array)
    array
}