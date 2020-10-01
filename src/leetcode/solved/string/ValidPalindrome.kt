package leetcode.solved.string

//125. Valid Palindrome

//Runtime: 184 ms, faster than 96.91%
//Memory Usage: 34.8 MB, less than 79.21%
fun isPalindrome(s: String): Boolean {
    var left = 0
    var right = s.length-1

    while (left < right) {

        while (!(s[left].isLetter() || s[left].isDigit())) {
            left++
            if (left >= right)
                return true
        }
        while (!(s[right].isLetter() || s[right].isDigit())) {
            right--
            if (right <= left)
                return true
        }

        if (s[left].toLowerCase() != s[right].toLowerCase())
            return false

        left++
        right--
    }

    return true
}

fun main() {
    print(isPalindrome("A masn, a plan, a canal: Panama"))
}
