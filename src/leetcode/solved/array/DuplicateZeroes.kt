package leetcode.solved.array

//1089. Duplicate Zeros

//Runtime: 256 ms, faster than 30.43%
//Memory Usage: 38.8 MB, less than 7.83%
fun duplicateZeros(arr: IntArray): Unit {
    var extra = 0

    var index = 0
    while(index+extra < arr.size){
        if(arr[index] == 0)
            extra++
        index++
    }
    if(extra+index>arr.size)
        extra--

    if(extra==0)
        return

    var i = arr.size-extra-1
    while(i>=0){
        arr[i+extra] = arr[i]
        i--
    }

    var k = 0
    while(extra<arr.size && k<extra){
        arr[k] = arr[extra]
        if(arr[k]==0){
            arr[k+1] = 0
            k++
        }
        k++
        extra++
    }

}

fun main(){
    println(duplicateZeros(intArrayOf(1,0,2,0,6,8,8,6,0)))

}