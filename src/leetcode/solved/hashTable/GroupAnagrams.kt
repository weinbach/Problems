package leetcode.solved.hashTable

import kotlin.collections.ArrayList
import kotlin.collections.HashMap

// 49. Group Anagrams
// Runtime: 308 ms, faster than 77.83%
// Memory Usage: 44.2 MB, less than 44.80%
fun groupAnagrams(strs: Array<String>): List<List<String>> {
    val res = ArrayList<ArrayList<String>>()
    val map = HashMap<String, ArrayList<String>>()

    for (i in 0..strs.lastIndex){
        val charArray: CharArray = strs[i].toCharArray()
        charArray.sort()
        val string = String(charArray)

        if(map.containsKey(string))
            map[string]!!.add(strs[i])
        else
            map[string] = ArrayList<String>().apply { add(strs[i]) }
    }
    for((_, value) in map){
        res.add(value)
    }
    return res
}

fun main(){
    val asd = groupAnagrams(arrayOf("eat","tea","tan","ate","nat","bat"))
}