package sorts

fun quickSortCustom(array: IntArray, left: Int, right: Int) {
    if (right <= left)
        return
    val divider = partition(array, left, right)
    quickSortCustom(array, left, divider - 1)
    quickSortCustom(array, divider + 1, right)
}

fun getMedianIndex(array: IntArray, left: Int, right: Int): Int {
    val middle = (right + left) / 2
    when {
        array[left] > array[middle] -> {
            return when {
                array[left] < array[right] -> left
                array[middle] > array[right] -> middle
                else -> right
            }
        }
        else -> {
            return when {
                array[left]>array[right] -> left
                array[middle]>array[right] -> right
                else -> middle
            }
        }

    }
}

fun partition(array: IntArray, left: Int, right: Int): Int {
    val pivot: Int = if (right - left >= 2) getMedianIndex(array, left, right) else right

    val pivotVal =  array[pivot]
    array[pivot] = array[right]
    array[right] = pivotVal

    var i = left -1
    for (j in left until right){
        if (array[j]<pivotVal){
            i+=1
            val temp = array[j]
            array[j] = array[i]
            array[i] = temp
        }
    }

    val temp = array[i+1]
    array[i+1] = pivotVal
    array[right] = temp

    return i+1
}

fun main(){
    val arr = intArrayOf(9,2,7,3,5,0,-1,248,15,12,13,1,1,9)
    quickSortCustom(arr, 0, arr.lastIndex)
    val s = 2

}
