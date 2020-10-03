package leetcode.solved.string

//58. Length of Last Word

//Runtime: 144 ms, faster than 99.44%
//Memory Usage: 34 MB, less than 81.79%
fun lengthOfLastWord(s: String): Int {
    var count = 0

    for(i in s.length-1 downTo 0){
        if(s[i] != ' '){
            for(j in i downTo 0){
                if(s[j] == ' ')
                    return count
                count++
            }
            return count
        }

    }
    return 0
}