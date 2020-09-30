package leetcode.solved

//860. Lemonade Change

//Runtime: 216 ms, faster than 50.00%
//Memory Usage: 37.9 MB, less than 37.50% 
fun lemonadeChange(bills: IntArray): Boolean {
    val back = intArrayOf(0,  0)
    for(i in 0 until bills.size){
        when(bills[i]){
            5 -> back[0] = back[0] + 1
            10 -> {
                if(back[0] <= 0)
                    return false
                else{
                    back[0] = back[0] -1
                    back[1] = back[1] +1
                }
            }
            20 -> {
                if(back[0] <= 0)
                    return false
                if(back[1] > 0){
                    back[1] = back[1] - 1
                    back[0] = back[0] -1
                } else{
                    if(back[0] < 3)
                        return false
                    else
                        back[0] = back[0]-3
                }
            }
        }
    }
    return true
}