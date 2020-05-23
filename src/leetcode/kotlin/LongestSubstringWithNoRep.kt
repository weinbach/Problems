fun lengthOfLongestSubstring(s: String): Int {
    var startIndex = 0
    var endIndex = 0
    var length = 0

    s.indices.forEach { i ->
        val charIn = s.substring(startIndex, endIndex).indexOf(s[i])
        if (charIn != -1) {
            startIndex += charIn + 1
        }
        endIndex++

        if (length < endIndex - startIndex)
            length = endIndex - startIndex

        if (s.length - startIndex < length)
            return length
    }

    return length
}