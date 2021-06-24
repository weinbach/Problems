package sorts

private fun mergseSort(array: IntArray){
    mergeSort(0, array.size-1, array, IntArray(array.size))
}

fun mergeSort(left: Int, right: Int, array: IntArray, tempArray: IntArray){

    if(left>=right)
        return

    val middle: Int = (left+right)/2

    mergeSort(left,middle, array, tempArray)
    mergeSort(middle+1, right, array, tempArray)
    mergeHalves(left, right, array, tempArray)

}

fun mergeHalves(leftStart: Int, rightEnd: Int, array: IntArray, tempArray: IntArray){

    val leftEnd: Int = (leftStart+rightEnd)/2
    val rightStart: Int = leftEnd+1

    var leftIterator = leftStart
    var rightIterator = rightStart
    var insertingIndex = leftStart

    while (leftIterator<=leftEnd && rightIterator<=rightEnd){
        if(array[leftIterator]<=array[rightIterator]){
            tempArray[insertingIndex] = array[leftIterator]
            leftIterator++
        } else{
            tempArray[insertingIndex] = array[rightIterator]
            rightIterator++
        }
        insertingIndex++
    }

    if(leftIterator>leftEnd){
        System.arraycopy(array, rightIterator, tempArray, insertingIndex, rightEnd-rightIterator+1)
    } else{
        System.arraycopy(array, leftIterator, tempArray, insertingIndex, leftEnd-leftIterator+1)
    }

    System.arraycopy(tempArray, leftStart, array, leftStart, rightEnd-leftStart+1)

}

fun main(){
    val array = intArrayOf(9,2,7,3,5,0,-1,248,15,12,13,1,1,9)
    //mergeSort(array)
     array
}