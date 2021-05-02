package leetcode.solved.hashTable

// 953. Verifying an Alien Dictionary
// Runtime: 204 ms, faster than 22.62%
// Memory Usage: 37 MB, less than 21.83%
fun isAlienSorted(words: Array<String>, order: String): Boolean {
    val charWeight = HashMap<Char, Int>()
    for(i in 0..order.lastIndex){
        charWeight[order[i]] = i
    }
    for(i in 0 until words.lastIndex){
        if(compare(words[i], words[i+1], charWeight) == 1)
            return false
    }

    return true
}

fun compare(a: String, b: String, charWeight: HashMap<Char, Int>): Int{
    var result = 0

    var one = 0
    var two = 0
    while(one<=a.lastIndex && two<=b.lastIndex){
        when{
            charWeight[a[one]]!! > charWeight[b[two]]!! ->
                return 1
            charWeight[a[one]]!! < charWeight[b[two]]!! ->
                return -1
        }
        one++
        two++
    }

    when {
        one<=a.lastIndex -> {
            result = 1
        }
        two<=b.lastIndex -> {
            result -1
        }
        else -> {
            result = 0
        }
    }

    return result
}

fun main(){
//    ["hello","leetcode"]
 //   "hlabcdefgijkmnopqrstuvwxyz"
    print(isAlienSorted(arrayOf("hello","leetcode"),"hlabcdefgijkmnopqrstuvwxyz"))
}