package leetcode.solved.backtrack

// 39. Combination Sum
// Runtime: 248 ms, faster than 54.42%
// Memory Usage: 40.3 MB, less than 46.94% 
val combinations = ArrayList<ArrayList<Int>>()

fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
    combinate(ArrayList(), candidates, target, 0)
    return combinations
}

fun combinate(combination: ArrayList<Int>, candidates: IntArray, target: Int, startIndex: Int){

    var lastRoute = -1
    for(i in candidates.lastIndex downTo startIndex){
        if(target-candidates[i]>=0){
            lastRoute = i
            break
        }
    }

    for(i in startIndex..lastRoute){
        if(i==lastRoute){
            combination.add(candidates[lastRoute])
            if(target-candidates[i]==0)
                combinations.add(combination)
            else
                combinate(combination, candidates, target-candidates[i], if(i==startIndex) startIndex else i)
        } else{
            if(target-candidates[i]==0){
                val newCombination = ArrayList<Int>(combination)
                newCombination.add(candidates[i])
                combinations.add(newCombination)
            } else if(target-candidates[i]>0){
                val newCombination = ArrayList<Int>(combination)
                newCombination.add(candidates[i])
                combinate(newCombination, candidates, target-candidates[i], if (i==startIndex) startIndex else i)
            }
        }
    }

}

fun main() {
    val asd = combinationSum(intArrayOf(2,3,5), 8)
    val s = 2
}