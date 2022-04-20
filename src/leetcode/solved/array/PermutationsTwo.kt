package leetcode.solved.array

import java.util.LinkedList

// 47. Permutations II
// Runtime: 533 ms, faster than 47.18%
// Memory Usage: 55.5 MB, less than 41.55%
private val permutations = ArrayList<List<Int>>()

private fun permutationsWithDuplicatedValues(nums: IntArray): List<List<Int>> {

    ConstructSequence(LinkedList(nums.toList()), LinkedList())
    return permutations

}

private fun ConstructSequence(elements: LinkedList<Int>, currentSequence: LinkedList<Int>){
    val usedLetters = HashSet<Int>()

    if(elements.isEmpty()){
        permutations.add(currentSequence)
        return
    }

    for(i in 0..elements.lastIndex){
        if(usedLetters.contains(elements[i]))
            continue
        usedLetters.add(elements[i])

        if(i == elements.lastIndex){
            currentSequence.add(elements[i])
            elements.removeAt(i)
            ConstructSequence(elements, currentSequence)
        } else {
            val copiedSequence: LinkedList<Int> = LinkedList(currentSequence)
            copiedSequence.add(elements[i])
            val copiedElements = LinkedList(elements)
            copiedElements.removeAt(i)
            ConstructSequence(copiedElements, copiedSequence)
        }
    }

}

fun main(){
    permutationsWithDuplicatedValues(intArrayOf(1,2,1))
    print(permutations)
}