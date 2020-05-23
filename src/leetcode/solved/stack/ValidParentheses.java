package leetcode.solved.stack;

import java.util.Stack;

public class ValidParentheses {
    //#20 Valid Parentheses
    public static void main(String[] args) {
        isValid("()");
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '(':
                case '{':
                case '[':
                    stack.push(s.charAt(i));
                    break;
                case ')':
                    if (stack.empty() || stack.pop() != '(')
                        return false;
                    break;
                case '}':
                    if (stack.empty() || stack.pop() != '{')
                        return false;
                    break;
                case ']':
                    if (stack.empty() || stack.pop() != '[')
                        return false;
                    break;
            }
        }

        return stack.empty();
    }
}
