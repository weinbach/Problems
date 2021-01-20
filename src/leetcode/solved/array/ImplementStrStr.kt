package leetcode.solved.array

//28. Implement strStr()
//Runtime: 164 ms, faster than 75.94%
//Memory Usage: 35.7 MB, less than 55.61%
private fun strStr(haystack: String, needle: String): Int {
    var needleIndex = 0
    var res = 0

    if(needle.length == 0)
        return 0

    var i = 0
    while(i<haystack.length){
        if(haystack[i] == needle[needleIndex]){
            if(needleIndex == 0)
                res = i
            needleIndex++
            if(needleIndex == needle.length)
                return res
        } else {
            if(needleIndex>0)
                i = res
            needleIndex = 0
        }
        i++
    }

    return -1
}