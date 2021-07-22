package leetcode.solved.priority_queue

import java.util.*
import kotlin.Comparator

// 1094. Car Pooling
// Runtime: 192 ms, faster than 68.75%
// Memory Usage: 41.5 MB, less than 25.00%
fun carPooling(trips: Array<IntArray>, capacity: Int): Boolean {
    var load = 0
    val starts = trips.sortedWith(Comparator { o1, o2 ->
        val res = when {
            o1[1] > o2[1] -> 1
            o2[1] > o1[1] -> -1
            else -> 0
        }
        res
    })

    val ends = PriorityQueue<IntArray>{ o1, o2 ->
        val res = when{
            o1[2] > o2[2] -> 1
            o2[2] > o1[2] -> -1
            else -> -1
        }
        res
    }
    for(i in 0..starts.lastIndex){
        while(ends.isNotEmpty() && ends.peek()[2] <= starts[i][1])
            load-=ends.poll()[0]
        load+=starts[i][0]
        ends.add(starts[i])

        if(load>capacity)
            return false
    }

    return true
}

fun main(){
    carPooling(arrayOf(
            intArrayOf(2,1,5),
            intArrayOf(3,3,7),
            intArrayOf(1,2,2)
    ), 2)
}
