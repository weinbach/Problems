package leetcode.solved.string

//5. Longest Palindromic Substring

//Runtime: 180 ms, faster than 91.67%
//Memory Usage: 34.1 MB, less than 89.04%
fun longestPalindrome(s: String): String {
    var bestLength = 0
    var bestSubstr = ""

    for(mid in s.indices){
        var x = 0
        while (mid-x>=0 && mid+x<s.length){
            if(s[mid-x] != s[mid+x])
                break
            val length = x*2+1
            if(length>bestLength){
                bestLength = length
                bestSubstr = s.substring(mid-x, mid+x+1)
            }
            x++
        }
    }

    for(mid in s.indices){
        var x = 1
        while (mid-x+1>=0 && mid+x<s.length){
            if(s[mid-x+1] != s[mid+x])
                break
            val length = x*2
            if (length>bestLength){
                bestLength = length
                bestSubstr = s.substring(mid-x+1, mid+x+1)
            }
            x++
        }
    }

    return bestSubstr
}

fun main(){
    print(longestPalindrome("babad"))
}