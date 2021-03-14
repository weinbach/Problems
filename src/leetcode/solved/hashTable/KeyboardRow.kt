package leetcode.solved.hashTable

// 500. Keyboard Row
// Runtime: 168 ms, faster than 54.55%
// Memory Usage: 36.6 MB, less than 9.09%
val qwertyRows = arrayOf(
        HashSet<Char>().apply {
            addAll(arrayOf('q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'))
        },
        HashSet<Char>().apply {
            addAll(arrayOf('a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l'))
        },
        HashSet<Char>().apply {
            addAll(arrayOf('z', 'x', 'c', 'v', 'b', 'n', 'm'))
        })

fun findWords(words: Array<String>): Array<String> {
    val res = ArrayList<String>()
    for (word in words) {
        if (wordMatchQwertyRow(word))
            res.add(word)
    }
    return res.toTypedArray()
}

fun wordMatchQwertyRow(word: String): Boolean {
    var wordBelongingRow = -1
    for (i in 0..qwertyRows.lastIndex) {
        if (qwertyRows[wordBelongingRow].contains(word[0])) {
            wordBelongingRow = i
            break
        }
    }

    for (i in 1..word.lastIndex) {
        if (!qwertyRows[wordBelongingRow].contains(word[i]))
            return false
    }
    return true
}