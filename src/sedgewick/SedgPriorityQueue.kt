package sedgewick

import sedgewick.CustomStackArray.less
import java.io.IOException

class SedgPriorityQueue<Key : Comparable<Key>> {

    // Binary Heaps implementation of Priority Queue

    var values = arrayOfNulls<Any>(2) as Array<Key?>
    var N = 0

    fun insert(v: Key) {
        if(N == values.size)
            resize()
        values[++N] = v
        swim(N)
    }

    fun poll(): Key {
        if (N==0)
            throw IOException()
        if(N<=values.size/4)
            shrink()
        val res = values[1]
        exch(1, N--)
        sink(1)
        values[N+1] = null
        return res!!
    }

    fun peak(): Key {
        if(N==0)
            throw IOException()
        return values[N]!!
    }

    fun isEmpty(): Boolean {
        return N==1
    }

    private fun sink(k: Int) {
        var i = k
        while(i*2<=N){
            var max = i*2
            if(less(values[max], values[max+1])) max++
            if(!less(values[i], values[max])) break
            exch(max, i)
            i=max
        }
    }
    private fun swim(k: Int) {
        var i = k
        while (i > 1 && less(values[i / 2], values[i])) {
            exch(i, i / 2)
            i /= 2
        }
    }
    private fun exch(a: Int, b: Int) {
        val temp = values[a]
        values[a] = values[b]
        values[b] = temp
    }

    private fun resize(){
        val resized = arrayOfNulls<Any>(values.size*2) as Array<Key?>
        for(i in 1..values.lastIndex)
            resized[i] = values[i]
        values = resized
    }
    private fun shrink(){
        val shrunk = arrayOfNulls<Any>(values.size/2) as Array<Key?>
        for(i in 1..N)
            shrunk[i] = values[i]
        values = shrunk
    }

}