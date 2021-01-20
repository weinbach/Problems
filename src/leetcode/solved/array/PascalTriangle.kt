package leetcode.solved.array

//118. Pascal's Triangle
//Runtime: 156 ms, faster than 58.67%
//Memory Usage: 35.7 MB, less than 22.67% 
fun generate(numRows: Int): List<List<Int>> {
    val arr = ArrayList<List<Int>>()
    if(numRows>0)
        arr.add(ArrayList<Int>(1).apply { add(1) })

    for(i in 1 until numRows){
        val list = IntArray(i+1)
        list[0] = 1
        list[i] = 1
        for (j in 1 until Math.round((i+1)/2.0).toInt()){
            list[j] = arr[i-1][j-1] + arr[i-1][j]
            list[i-j] = list[j]
        }
        arr.add(list.toList())
    }

    return arr
}

fun main(){
    val ar = generate(5)
    val asd = 2
}