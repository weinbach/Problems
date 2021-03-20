package leetcode.solved.hashTable

import kotlin.collections.HashMap

// 76. Minimum Window Substring
// Runtime: 260 ms, faster than 53.04%
// Memory Usage: 40.6 MB, less than 41.74%
fun minWindow(s: String, t: String): String {

    val mainHash = HashMap<Char, Int>()
    for (i in 0..t.lastIndex) {
        if (mainHash.contains(t[i])) {
            mainHash[t[i]] = mainHash[t[i]]!! + 1
        } else {
            mainHash[t[i]] = 1
        }
    }

    var charsDone = 0
    val iteratingHash = HashMap<Char, Int>()

    var resStart = 0
    var resEnd = 0
    var anyWindowFound = false

    var leftIndex = 0
    var rightIndex = 0

    while (charsDone == t.length || rightIndex<=s.lastIndex) {
        if (charsDone == t.length) {
            if(!anyWindowFound){
                resEnd = rightIndex - 1
                anyWindowFound = true
            } else{
                if(resEnd-resStart>rightIndex-1-leftIndex){
                    resStart = leftIndex
                    resEnd = rightIndex - 1
                }
            }
            if(iteratingHash.contains(s[leftIndex])){
                if(iteratingHash[s[leftIndex]]!!-1 < mainHash[s[leftIndex]]!!){
                    charsDone--
                }
                iteratingHash[s[leftIndex]] = iteratingHash[s[leftIndex]]!! - 1
            }
            leftIndex++
        } else {
            if (!mainHash.contains(s[rightIndex])) {
                rightIndex++
                continue
            }

            if (iteratingHash.contains(s[rightIndex])) {
                iteratingHash[s[rightIndex]] = iteratingHash[s[rightIndex]]!! + 1
                if (iteratingHash[s[rightIndex]]!! <= mainHash[s[rightIndex]]!!)
                    charsDone++
            } else {
                iteratingHash[s[rightIndex]] = 1
                charsDone++
            }
            rightIndex++
        }

    }
    return if (anyWindowFound) s.substring(resStart, resEnd+1) else ""
}



fun main() {
    print(minWindow("A", "A"))
}
