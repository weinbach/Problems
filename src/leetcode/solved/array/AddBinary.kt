package leetcode.solved.array

// 67. Add Binary
// Runtime: 230 ms, faster than 67.69%
// Memory Usage: 36.8 MB, less than 42.05%
fun addBinary(a: String, b: String): String {

    var aPt = a.lastIndex
    var bPt = b.lastIndex

    val builder = StringBuilder(Math.max(a.lastIndex, b.lastIndex))

    var carry = 0
    while(aPt>=0 && bPt>=0){
        val sum = carry + Character.getNumericValue(a[aPt--]) + Character.getNumericValue(b[bPt--])
        val res = sum%2
        carry = if(sum>1) 1 else 0
        builder.append(res)
    }
    while(bPt>=0){
        val sum = carry + Character.getNumericValue(b[bPt--])
        val res = sum%2
        carry = if(sum>1) 1 else 0
        builder.append(res)
    }
    while(aPt>=0){
        val sum = carry + Character.getNumericValue(a[aPt--])
        val res = sum%2
        carry = if(sum>1) 1 else 0
        builder.append(res)
    }
    if(carry>0)
        builder.append(1)

    builder.reverse()
    return builder.toString()

}
