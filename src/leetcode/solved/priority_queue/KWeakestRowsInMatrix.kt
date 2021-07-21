package leetcode.solved.priority_queue

import java.util.*

//1337. The K Weakest Rows in a Matrix
//Runtime: 208 ms, faster than 88.24%
//Memory Usage: 43.2 MB, less than 70.59%
fun kWeakestRows(mat: Array<IntArray>, k: Int): IntArray {
    val weight = IntArray(mat.size){0}
    for(i in 0..mat.lastIndex){
        for(j in 0..mat[0].lastIndex){
            weight[i] = weight[i] + mat[i][j]
        }
    }

    val pq = PriorityQueue<Int>{ o1, o2 ->
        val res: Int = when{
            weight[o1] > weight[o2] -> 1
            weight[o2] > weight[o1] -> -1
            else -> {
                if(o1 > o2) 1
                else -1
            }
        }
        res
    }
    for(i in 0..mat.lastIndex)
        pq.add(i)
    val res = IntArray(k){0}
    for(i in 0 until k){
        res[i] = pq.poll()
    }

    return res
}

fun main(){
    val arr = arrayOf(
            intArrayOf(1,1,0,0,0),
            intArrayOf(1,1,1,1,0),
            intArrayOf(1,0,0,0,0),
            intArrayOf(1,1,0,0,0),
            intArrayOf(1,1,1,1,1)
    )
    kWeakestRows(arr, 3)
}