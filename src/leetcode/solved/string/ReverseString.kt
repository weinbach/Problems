package leetcode.solved.string

//344. Reverse String

//Runtime: 244 ms, faster than 76.03%
//Memory Usage: 42.1 MB, less than 92.47%
fun reverseString(s: CharArray): Unit {
    var index = 0
    while(index<=(s.size+1)/2-1){
        var temp = s[index]
        s[index] = s[s.size-1-index]
        s[s.size-1-index] = temp
        index++
    }
}