package leetcode.solved.backtrack

// 40. Combination Sum II
// Runtime: 2276 ms, faster than 5.43%
// Memory Usage: 41.7 MB, less than 35.87%
fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
    val result = HashSet<ArrayList<Int>>()
    candidates.sort()
    call(ArrayList(), 0, target, candidates, result)
    return result.toList()
}

fun call(list: ArrayList<Int>, index: Int, rest: Int, candidates: IntArray, res: HashSet<ArrayList<Int>>){
    for(i in index..candidates.lastIndex){
        if(candidates[i]<=rest){
            val subList = ArrayList<Int>().apply {
                addAll(list)
            }
            subList.add(candidates[i])
            if (rest-candidates[i]==0){
                res.add(subList)
                break
            }
            if (i<candidates.lastIndex)
                call(subList, i+1, rest-candidates[i], candidates, res)
        } else break
    }
}

fun main(){
    val asd = combinationSum2(intArrayOf(10,1,2,6,7,1,5), 8)
    val s = 2
}