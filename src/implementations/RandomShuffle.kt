package codesignal

// Knuth shuffle
// produces uniformly random permutation
fun shuffle(nums: IntArray) {
    var rnd: Int
    for (i in 1..nums.lastIndex) {
        rnd = (0..i).random()
        val temp = nums[rnd]
        nums[rnd] = nums[i]
        nums[i] = temp
    }
}