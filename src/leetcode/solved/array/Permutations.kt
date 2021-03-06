package leetcode.solved.array

//46. Permutations
// Runtime: 232 ms, faster than 28.82%
// Memory Usage: 38 MB, less than 63.53%
val permutes = ArrayList<List<Int>>()

private fun permute(nums: IntArray): List<List<Int>> {
    doit(nums, HashMap())
    return permutes
}

private fun doit(nums: IntArray, permutation: HashMap<Int, Int>) {
    for (i in 0..nums.lastIndex) {
        if (!permutation.containsValue(nums[i])) {
            if (i == nums.lastIndex) {
                permutation.put(permutation.size, nums[i])
                if (permutation.size < nums.size)
                    doit(nums, permutation)
                else if (permutation.size == nums.size)
                    permutes.add(permutation.values.toList())
            } else {
                val newPermutation = HashMap<Int, Int>(permutation)
                newPermutation.put(newPermutation.size, nums[i])
                if (newPermutation.size == nums.size)
                    permutes.add(newPermutation.values.toList())
                else
                    doit(nums, newPermutation)
            }
        }
    }
}

fun main() {
    print(permute(intArrayOf(1, 2, 3)))

}