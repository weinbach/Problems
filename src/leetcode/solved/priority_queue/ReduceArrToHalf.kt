package leetcode.solved.priority_queue

//1338. Reduce Array Size to The Half
//Runtime: 552 ms, faster than 79.87%
//Memory Usage: 52 MB, less than 75.17%
fun minSetSize(arr: IntArray): Int {
    var minSet = 0
    val uniqueValues = HashMap<Int, Int>()
    for(i in 0..arr.lastIndex){
        if(uniqueValues.contains(arr[i])){
            uniqueValues[arr[i]] = uniqueValues[arr[i]]!! + 1
        } else{
            uniqueValues[arr[i]] = 1
        }
    }

    val heap = IntArray(uniqueValues.size+2){ 0 }
    var N: Int = uniqueValues.size

    var index = 1
    for(i in uniqueValues)
        heap[index++] = i.value

    if(heap.size == 3)
        return 1

    fun exchange(a: Int, b: Int){
        val temp = heap[a]
        heap[a] = heap[b]
        heap[b] = temp
    }

    fun sinkOnce(k: Int): Int{
        val max = if(heap[k*2]>heap[k*2+1]) k*2 else k*2+1
        if(heap[k] >= heap[max]) return k
        exchange(k, max)
        return max
    }

    fun sink(k: Int){
        var i = k
        while(i*2<=N){
            val max = if(heap[i*2]>heap[i*2+1]) i*2 else i*2+1
            if(heap[i] >= heap[max]) break
            exchange(max, i)
            i=max
        }
    }

    fun getMax(): Int{
        val res = heap[1]
        exchange(1, N--)
        heap[N+1] = 0
        sink(1)
        return res
    }

    for(i in (heap.size-2)/2 downTo 1){
        sink(sinkOnce(i))
    }

    var arrRest = arr.size
    while(arrRest>(arr.size+1)/2){
        arrRest-=getMax()
        minSet++
    }
    return minSet
}

fun main(){
    print(minSetSize(intArrayOf(9,77,63,22,92,9,14,54,8,38,18,19,38,68,58,19)))
}