package leetcode.solved.hashTable

//575. Distribute Candies
fun distributeCandies(candyType: IntArray): Int {
    val candyTypes = HashSet<Int>()
    var differentCandies = 0

    var i = 0
    while(differentCandies<candyType.size/2 && i<=candyType.lastIndex){
        if(!candyTypes.contains(candyType[i])){
            differentCandies++
            candyTypes.add(candyType[i])
        }
        i++
    }
    return differentCandies
}