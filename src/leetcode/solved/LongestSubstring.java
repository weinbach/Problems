package leetcode.solved;

public class LongestSubstring {
    //#3 Longest Substring Without Repeating Characters
    public static void main(String[] args) {
        System.out.println("result: "  + lengthOfLongestSubstring("dvdf"));
    }

    public static int lengthOfLongestSubstring(String s) {
        int length = 0;
        int startIndex = 0;
        int endIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            int charIn = s.substring(startIndex, endIndex).indexOf(s.charAt(i));
            if (charIn != -1) {
                startIndex = startIndex + charIn + 1;
            }
            endIndex++;

            if (length < (endIndex - startIndex))
                length = endIndex - startIndex;

        }
        return length;
    }

}
