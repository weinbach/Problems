package leetcode.solved

//412. Fizz Buzz
fun fizzBuzz(n: Int): List<String> {
    val result = ArrayList<String>()

    for( i in 1..n){
        when{
            i%3 == 0 && i%5 == 0 -> result.add("FizzBuzz")
            i%3 == 0  -> result.add("FizzBuzz")
            i%5 == 0 -> result.add("Buzz")
            else -> result.add(i.toString())
        }
    }

    return result
}