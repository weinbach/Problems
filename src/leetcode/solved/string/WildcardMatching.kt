package leetcode.solved.string

//44. Wildcard Matching

//Runtime: 216 ms, faster than 47.06%
//Memory Usage: 37.1 MB, less than 35.29%
private fun isMatch(s: String, p: String): Boolean {
    var patternIndex = 0
    var stringIndex = 0

    while (patternIndex < p.length) {
        if (p[patternIndex] == '*') {
            if (patternIndex == p.lastIndex)
                return true

            // searching for all substring between closest *
            var multipleAsterisk = false
            var subStrEnd = patternIndex + 1

            while (subStrEnd <= p.lastIndex) {
                if (p[subStrEnd] == '*') {
                    multipleAsterisk = true
                    break
                }
                subStrEnd++
            }

            if (multipleAsterisk) {
                if (subStrEnd == patternIndex + 1) {
                    patternIndex++
                    continue
                }

                val subStr = p.substring(patternIndex + 1, subStrEnd)
                val occurrences = findAllSubstringOccurrences(subStr, s.substring(stringIndex, s.length))

                for (occurrence in occurrences) {
                    if (occurrence + 1 <= s.length) {
                        return isMatch(s.substring(occurrence + stringIndex + 1, s.length), p.substring(subStrEnd, p.length))
                    }
                }
                return false
            } else {
                val leftElementsInPattern = p.lastIndex - patternIndex
                patternIndex++
                if (leftElementsInPattern > s.length - stringIndex)
                    return false
                stringIndex = s.length - leftElementsInPattern
            }
        } else if (p[patternIndex] == '?') {
            if (stringIndex > s.lastIndex)
                return false

            patternIndex++
            stringIndex++
        } else {
            if (stringIndex > s.lastIndex)
                return false

            if (s[stringIndex] == p[patternIndex]) {
                stringIndex++
                patternIndex++
            } else {
                return false
            }
        }
    }

    return stringIndex == s.length && patternIndex == p.length
}

private fun findAllSubstringOccurrences(substring: String, s: String): ArrayList<Int> {
    //returns list of last index of occurrences
    val occurrences = ArrayList<Int>()

    if (s.length < substring.length)
        return occurrences

    fun occurrence(start: Int) {
        if (s.length - start < substring.length)
            return
        var i = start
        var j = 0
        while (j < substring.length) {
            if (substring[j] != '?' && s[i] != substring[j])
                break
            if (j == substring.lastIndex) {
                occurrences.add(i)
            }
            i++
            j++
        }
    }

    for (i in 0..s.lastIndex)
        occurrence(i)

    return occurrences
}

fun main() {
    print(isMatch("bbbbbbbabbaabbabbbbaaabbabbabaaabbababbbabbbabaaabaab", "b*b*ab**ba*b**b***bba"))

}
//mississippi
//m??*ss*?i*pi