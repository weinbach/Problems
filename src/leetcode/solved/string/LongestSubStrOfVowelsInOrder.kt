package leetcode.solved.string

// 1839. Longest Substring Of All Vowels in Order
// Runtime: 316 ms, faster than 94.12%
// Memory Usage: 45.8 MB, less than 76.47%
fun longestBeautifulSubstring(word: String): Int {
    if(word.length<5)
        return 0

    var bestLen = 0
    var currLen = 0

    var charOrderIndex = 0

    val orderedVowels = arrayOf('a', 'e', 'i', 'o', 'u')

    var i = 0
    while(i in 0..word.lastIndex){
        if(word[i] == orderedVowels[charOrderIndex]){
            currLen++
            while(i<word.lastIndex && word[i+1] == orderedVowels[charOrderIndex]){
                currLen++
                i++
            }
            if(charOrderIndex == orderedVowels.lastIndex){
                if(currLen>bestLen)
                    bestLen = currLen
                currLen = 0
                charOrderIndex = 0
            }
            else
                charOrderIndex++
        } else{
            currLen = 0
            if(word[i]=='a')
                i--
            charOrderIndex = 0
        }
        i++
    }

    return bestLen
}