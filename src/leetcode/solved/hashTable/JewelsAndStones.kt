package leetcode.solved.hashTable

//771. Jewels and Stones

//Runtime: 148 ms, faster than 87.23%
//Memory Usage: 33.3 MB, less than 56.74%
fun numJewelsInStones(J: String, S: String): Int {

    var jewelsCount = 0
    val hashSet = HashSet<Char>()
    for(char in J){
        hashSet.add(char)
    }

    for(char in S){
        if(hashSet.contains(char))
            jewelsCount++
    }

    return jewelsCount

}