package sorts

import sedgewick.CustomStackArray.less

fun mergeSort(a: Array<Comparable<*>>) {
    val aux = Array<Comparable<*>?>(a.size){ null }
    mergeSort(a, aux, 0, a.lastIndex)
}

// Recursive solution
private fun mergeSort(a: Array<Comparable<*>>, aux: Array<Comparable<*>?>, start: Int, end: Int) {
    if(end<=start)
        return
    val mid = start + (end - start) / 2
    mergeSort(a, aux, start, mid)
    mergeSort(a, aux, mid+1, end)
    merge(a, aux, start, end, mid)
}

// Iterative solution
fun bottomUpMergeSort(a: Array<Comparable<*>>){
    val N = a.size
    val aux = Array<Comparable<*>?>(N){ null }

    var sz = 1
    while (sz<N){
        var k = 0
        while (N-k>sz){
            merge(a, aux, k, Math.min(k+sz*2-1, N-1), k+sz-1)
            k += sz * 2
        }
        sz *= 2
    }
}

private fun merge(a: Array<Comparable<*>>, aux: Array<Comparable<*>?>, start: Int, end: Int, middle: Int){
    var i = start
    var j = middle+1

    for(k in start..end)
        aux[k] = a[k]

    for(k in start..end){
        when{
            i>middle -> a[k] = aux[j++]!!
            j>end -> a[k] = aux[i++]!!
            less(aux[i], aux[j]) -> a[k] = aux[i++]!!
            else -> a[k] = aux[j++]!!
        }
    }
}

fun main(){
    val array = arrayListOf(9,2,7,3,5,0,-1,248,15,12,13,1,1,9)
    // Does not work for arr of comparable elements, but works for single element
    //mergeSort(asd)
}
