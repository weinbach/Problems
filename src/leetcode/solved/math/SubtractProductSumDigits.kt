package leetcode.solved.math

//1281. Subtract the Product and Sum of Digits of an Integer

//Runtime: 112 ms, faster than 99.10%
//Memory Usage: 32 MB, less than 32.43%
fun subtractProductAndSum(n: Int): Int {
    var product = 1
    var sum = 0
    var value = n
    while (value>0){
        val digit = value%10
        product *= digit
        sum+=digit
        value /= 10
    }

    return product-sum
}

fun main(){
    print(Math.log10(18.0))
}