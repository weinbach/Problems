package leetcode.solved.array

// 66. Plus One
// Runtime: 176 ms, faster than 55.02%
// Memory Usage: 36.3 MB, less than 54.69%
fun plusOne(digits: IntArray): IntArray {
    if(digits.last()!=9){
        digits[digits.lastIndex] = digits.last()+1
        return digits
    }
    var i = digits.lastIndex
    while(i>=0 && digits[i] == 9){
        digits[i]=0
        i--
    }
    if(i==-1){
        val arr = IntArray(digits.size+1){0}
        arr[0] = 1
        return arr
    }
    else{
        digits[i] = digits[i]+1
        return digits
    }
}