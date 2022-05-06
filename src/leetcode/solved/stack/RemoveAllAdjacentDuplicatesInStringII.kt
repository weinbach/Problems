package leetcode.solved.stack

// 1209. Remove All Adjacent Duplicates in String II
// Runtime: 359 ms, faster than 74.07%
// Memory Usage: 52.8 MB, less than 62.96%
fun removeDuplicates(s: String, k: Int): String {
    var head = Rode(0, ' ')
    var currNode: Rode? = head

    var i = 0
    while (i <= s.lastIndex) {
        val char = s[i]
        var count = 1
        var j = i + 1
        while (j <= s.lastIndex && s[j] == char) {
            count++
            j++
        }
        val newNode = Rode(count, char)
        newNode.prev = currNode
        currNode!!.next = newNode
        currNode = currNode.next!!
        i = j
    }

    currNode = head.next
    while (currNode != null && currNode.count > 0) {
        // sum and detach with previous
        if (currNode.prev!!.char == currNode.char) {
            currNode.count = currNode.count + currNode.prev!!.count

            val prePrev = currNode.prev!!.prev!!
            prePrev.next = currNode
            currNode.prev = prePrev
        }

        // sum and detach with next
        if (currNode.next != null && currNode.next!!.char == currNode.char) {
            currNode.count = currNode.count + currNode.next!!.count
            val nextNext = currNode.next!!.next
            currNode.next = nextNext
            if (nextNext != null)
                nextNext.prev = currNode
        }

        val res = currNode.count % k
        if (res == 0) {
            val prev = currNode.prev!!
            val next = currNode.next

            prev.next = next
            if (next != null)
                next.prev = prev
            currNode = next
        } else {
            currNode.count = res
            currNode = currNode.next
        }
    }

    if (head.next == null)
        return ""

    head = head.next!!
    currNode = head

    val strBuilder = java.lang.StringBuilder()
    while (currNode != null) {
        for (i in 1..currNode.count)
            strBuilder.append(currNode.char)
        currNode = currNode.next
    }
    return strBuilder.toString()

}

class Rode(var count: Int, var char: Char) {
    var next: Rode? = null
    var prev: Rode? = null
}

fun main() {
    print(removeDuplicates("deeedbbcccbdaa", 3))
}
/*
deeedbbcccbdaa
1d 3e 1d 2b 3c 1b 1d 2a
2d 2b 3c 1b 1d 2a
2d 3b 1d 2a
3d 2a
2a*/
