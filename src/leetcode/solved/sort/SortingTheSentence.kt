package leetcode.solved.sort

// 1859. Sorting the Sentence
// Runtime: 164 ms, faster than 76.19%
// Memory Usage: 36.8 MB, less than 25.40%
fun sortSentence(s: String): String {
    val words = ArrayList<Pair<Int,Int>>()
    var it = 0
    while (it <=s.lastIndex){
        var j = it
        while(j<=s.lastIndex && s[j]!=' ')
            j++
        words.add(Pair(it,j-1))
        it = j+1
    }

   val ordered = words.sortedWith { o1, o2 ->
        val res = when {
            s[o1.second] > s[o2.second] -> 1
            else -> -1
        }
        res
    }

    val builder = StringBuilder()
    for(i in 0..ordered.lastIndex){
        builder.append(s.subSequence(ordered[i].first, ordered[i].second))
        builder.append(" ")
    }
    builder.deleteCharAt(builder.lastIndex)
    return builder.toString()
}
fun main(){

    print(sortSentence("s2 sentence4 This1 a3"))
}