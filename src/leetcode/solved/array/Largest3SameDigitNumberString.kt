package leetcode.solved.array

// 2264. Largest 3-Same-Digit Number in String
// Runtime: 226 ms, faster than 52.17%
// Memory Usage: 35.8 MB, less than 63.04%
fun largestGoodInteger(num: String): String {
    var uinqe = -1
    val res = StringBuilder()

    var currSeq = 0
    var currChar: Char

    var i = 0
    while(i < num.lastIndex){
        currChar = num[i]
        while(i<=num.lastIndex && currChar == num[i] && currSeq <3){
            currSeq++
            i++
        }
        val curr = Character.getNumericValue(currChar)
        if(currSeq>=3 && curr>uinqe){
            uinqe = curr
        }
        currSeq = 0

        if(uinqe == 9)
            return "999"
    }

    if(uinqe == -1)
        return ""
    res.append(uinqe)
    res.append(uinqe)
    res.append(uinqe)

    return res.toString()
}