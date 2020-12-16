package leetcode.solved.string

//647. Palindromic Substrings

//Runtime: 160 ms, faster than 75.00%
//Memory Usage: 33.8 MB, less than 75.00%
fun countSubstrings(s: String): Int {
    var count = 0

    for(mid in s.indices){
        var x = 0
        while(mid-x>=0 && mid+x<s.length){
            if(s[mid-x]==s[mid+x]){
                count++
                x++
            } else break
        }
    }

    for(mid in s.indices){
        var x = 1
        while(mid-x+1>=0 && mid+x<s.length){
            if(s[mid-x+1] == s[mid+x]){
                count++
                x++
            } else break
        }
    }
    return count
}