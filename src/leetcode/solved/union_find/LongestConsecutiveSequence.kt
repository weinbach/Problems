package leetcode.solved.union_find

// 128. Longest Consecutive Sequence
// Runtime: 480 ms, faster than 10.71%
// Memory Usage: 43 MB, less than 5.36%
fun longestConsecutive(nums: IntArray): Int {
    if(nums.size<2)
        return nums.size
    val list = ArrayList<HashSet<Int>>()
    var max = 1
    for(i in 0..nums.lastIndex){
        var before:HashSet<Int>? = null
        var after:HashSet<Int>? = null
        for(set in list){
            if (set.contains(nums[i]+1))
                after = set
            if(set.contains(nums[i]-1))
                before = set
        }
        when{
            before != null && after != null -> {
                if (before==after)
                    before.add(nums[i])
                else{
                    before.addAll(after)
                    list.remove(after)
                    before.add(nums[i])
                }
                if(before.size>max)
                    max = before.size
            }
            before != null -> {
                before.add(nums[i])
                if(before.size>max)
                    max = before.size
            }
            after != null -> {
                after.add(nums[i])
                if(after.size>max)
                    max = after.size
            }
            else ->
                list.add( HashSet<Int>().apply { add(nums[i]) })
        }
    }
    return max
}

fun main(){
    val asd = HashSet<Int>().apply {
        add(2)
        add(-2)
        add(-20)
        add(5)
        add(0)
        add(15)
        add(-3)
    }
    for (i in asd)
        println(i)
}