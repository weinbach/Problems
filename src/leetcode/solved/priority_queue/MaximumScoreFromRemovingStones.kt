package leetcode.solved.priority_queue

// 1753. Maximum Score From Removing Stones
// Runtime: 148 ms, faster than 80.00%
// Memory Usage: 32.9 MB, less than 90.00%
fun maximumScore(a: Int, b: Int, c: Int): Int {
    var res = 0
    val arr = IntArray(3){0}
    arr[0] = a
    arr[1] = b
    arr[2] = c

    fun exchange(a: Int, b: Int){
        val temp = arr[a]
        arr[a] = arr[b]
        arr[b] = temp
    }

    for(i in 1..2){
        var k = i
        while(k>0 && arr[k]>arr[k-1]){
            exchange(k, k-1)
            k--
        }
    }
    while(arr[1]>0){
        res++
        arr[0] = arr[0] - 1
        arr[1] = arr[1] - 1

        val max = if(arr[1]>arr[2]) 1 else 2
        if(arr[max]>arr[0])
            exchange(max, 0)
        if(arr[2]> arr[1])
            exchange(2,1)
    }
    return res
}

fun main(){
    print(maximumScore(1,8, 8))
}