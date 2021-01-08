package leetcode.solved.string

//10. Regular Expression Matching
private fun isMatch(s: String, p: String): Boolean {
    if (s.isEmpty() && p.isEmpty())
        return true
    return check(0, 0, s, p)
}

private fun check(indexS: Int, indexP: Int, s: String, p: String): Boolean {

    if (indexP == p.lastIndex + 1 && indexS == s.lastIndex + 1)
        return true
    if (indexP > p.lastIndex && indexS <= s.lastIndex)
        return false

    if (indexP == p.lastIndex || p[indexP + 1] != '*') {

        if(indexS>s.lastIndex)
            return false
        if (p[indexP] == '.' || s[indexS] == p[indexP]) {
            if (indexP == p.lastIndex && indexS == s.lastIndex)
                return true
            else
                return check(1 + indexS, 1 + indexP, s, p)
        } else
            return false

    } else {
        return check(indexS, indexP + 2, s, p) || //Zero occurrences
                (if ( indexS <= s.lastIndex && (p[indexP] == '.' || s[indexS] == p[indexP])) {
                    check(indexS + 1, indexP, s, p)// one or more
                } else false) // count by one occurrence and check
    }

}

fun main() {
    print(isMatch("a", "ab*a"))
}