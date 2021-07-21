package leetcode.solved.priority_queue

import java.util.*
import kotlin.collections.HashMap

//451. Sort Characters By Frequency
//Runtime: 240 ms, faster than 85.71%
//Memory Usage: 37.6 MB, less than 95.92%
fun frequencySort(s: String): String {
    val values = HashMap<Char, Int>()
    for(i in 0..s.lastIndex){
        if(values.contains(s[i])){
            values[s[i]] = 1 + values[s[i]]!!
        } else{
            values[s[i]] = 1
        }
    }
    val pq = PriorityQueue<Char> { ch1, ch2 ->
        val res: Int = when{
            values[ch1]!! > values[ch2]!! -> -1
            values[ch2]!! > values[ch1]!! -> 1
            else -> 0
        }
        res
    }

    for(i in values){
        pq.add(i.key)
    }

    val result = CharArray(s.length){'a'}
    var item: Char
    var count = 0
    while(pq.isNotEmpty()){
        item = pq.poll()
        for(j in 1..values[item]!!)
            result[count++] = item
    }

    return String(result)
}

fun main(){
    print(frequencySort("tree"))
}
