package leetcode.solved.combinatorics

import java.util.*
import kotlin.math.ceil

// 60. Permutation Sequence
// Runtime: 284 ms, faster than 16.67%
// Memory Usage: 34.5 MB, less than 57.58%
val memo = HashMap<Int, Int>()

fun getPermutation(n: Int, k: Int): String {
    countPermutationsPerDigits(n)
    val layerChooseSequence = LinkedList<Int>()
    determineLayer(n, k, layerChooseSequence)

    /**
     * after we know each index of digit on each layer we gather them into one string
     *
     * @sample layers [2,3,1,1]
     * available [1 2 3 4] -> we get second: res "2"
     *              ^
     * available [1 3 4] -> we get third: res "24"
     *                ^
     * available [1 3] -> we get first: res "241"
     * available [3] -> we get first: res "2413"
     *
     * result -> "2413"
     */
    val linked = LinkedList<Int>()
    for (i in 1..n)
        linked.add(i)

    val res = StringBuilder()
    for (i in layerChooseSequence) {
        res.append(linked[i - 1])
        linked.removeAt(i - 1)
    }

    return res.toString()
}

/**
 * determine which digit from sequence would be
 * in each index
 *
 * we know exactly how many permutation contains each layer
 *
 * @sample n = 3
 * for each pack of permutations starting from 1, 2, .., n we have exactly (n-1)! permutations
 *
 * 123 - for the first
 * 132
 *
 * 213 - second
 * 231
 *
 * 312 - third
 * 321
 *
 * recursively detect which digit would be in front of each layer
 *
 * [1 2 3]
 *
 * if we know that our searching element is on third layer for first digit
 * then we deal only with [1 2] -> which contains 1! for each layer
 */
fun determineLayer(n: Int, k: Int, layerChooseSequence: LinkedList<Int>) {
    if (n == 1){
        layerChooseSequence.add(1)
        return
    }

    val division: Double = k.toDouble() / memo[n - 1]!!
    val layer = ceil(division).toInt()
    layerChooseSequence.add(layer)

    val remaining = k- (layer - 1) * memo[n - 1]!!
    determineLayer(n - 1, remaining, layerChooseSequence)

}

/**
 * calculates how many permutations per each amount of digits from 1 to n
 * and save it to memo for future multiple use
 * @sample 3->6; 4->24; 5->120 etc..
 */
fun countPermutationsPerDigits(n: Int) {
    var product = 1
    for (i in 1..n) {
        product *= i
        memo[i] = product
    }
}

fun main(){
    print(getPermutation(4, 9))
}