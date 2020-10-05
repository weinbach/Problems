package leetcode.solved.string

//14. Longest Common Prefix

//Runtime: 176 ms, faster than 84.44%
//Memory Usage: 34.9 MB, less than 61.48%
fun longestCommonPrefix(strs: Array<String>): String {

    if(strs.isEmpty() || strs[0].isEmpty())
        return ""
    if(strs.size==1)
        return strs[0]

    var i = 0
    while (true){
        for (index in 1 until strs.size){
            if(strs[index].isEmpty())
                return ""
            if (strs[0].length-1<i || strs[index].length-1<i || strs[index][i] != strs[0][i])
                return strs[0].substring(0,i)
        }
        i++
    }

}

fun main(){
    println(longestCommonPrefix(arrayOf("a","ab")))
}