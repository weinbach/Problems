package leetcode.solved.priority_queue

import java.util.*

//1046. Last Stone Weight
//Runtime: 164 ms, faster than 38.46%
//Memory Usage: 35.7 MB, less than 30.77%
fun lastStoneWeight(stones: IntArray): Int {
    val pq = PriorityQueue<Int>{ o1, o2->
        val res = when{
            o1>o2->-1
            o2>o1->1
            else -> 0
        }
        res
    }
    for(i in 0..stones.lastIndex)
        pq.add(stones[i])

    var temp = 0
    while(pq.size>1){
        temp = Math.abs(pq.poll()-pq.poll())
        if(temp!=0)
            pq.add(temp)
    }

    return if(pq.isEmpty()) 0 else pq.poll()
}