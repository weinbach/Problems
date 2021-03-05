package leetcode.solved.math

//50. Pow(x, n)
//Runtime: 176 ms, faster than 51.77%
//Memory Usage: 35.8 MB, less than 65.25%
val values = ArrayList<Double>()
val powers = ArrayList<Double>()

fun myPow(x: Double, n: Int): Double {
    if(n==0)
        return 1.0
    if(n==1)
        return x
    if(x==1.0)
        return 1.0

    calcPowers(x, abs(n.toDouble()))
    val negative = n<0

    if(powers.last() == abs(n.toDouble()))
        return if(negative) 1/ values.last() else values.last()

    var res = values.last()
    var powersLeft = abs(n.toDouble()) - powers.last()

    while (powersLeft!=0.0){
        val sqrs: Int = (searchVal(0, powers.lastIndex, Math.abs(powersLeft)))
        if(powersLeft>0){
            powersLeft -= powers[sqrs]
            res*=values[sqrs]
        } else{
            powersLeft += powers[sqrs]
            res/=values[sqrs]
        }
    }
    return if(negative) 1/res else res
}
fun calcPowers(x: Double, n: Double){
    values.add(x)
    powers.add(1.0)

    var i = 1
    while ((powers[i-1]*2)<=n){
        values.add(values[i-1]*values[i-1])
        powers.add(powers[i-1]*2)
        i++
    }

    if(powers.last() < n && (powers.last()*2 - n < n - powers.last())){
        powers.add(powers.last()*2)
        values.add(values.last()* values.last())
    }
}

fun abs(value: Double): Double{
    return if (value<0) -1*value else value
}

fun searchVal(left: Int, right: Int, n: Double): Int{
    if (right<left)
        return -1

    if(n==1.0)
        return 0

    val middle: Int = (left+right)/2

    if(powers[middle] == n)
        return middle
    if(powers[middle+1]> n && powers[middle-1]<n){
        return middle
    }
    if(powers[middle]<n){
        return searchVal(middle+1, right, n)
    } else{
        return searchVal(left, middle-1, n)
    }

}

fun main() {
    print(myPow(2.0, -2147483648))
}