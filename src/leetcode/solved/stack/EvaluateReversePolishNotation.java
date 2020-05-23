package leetcode.solved.stack;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    //#150 Evaluate Reverse Polish Notation
    public static void main(String[] args) {
        String[] strings = new String[]{ "3","11","5","+","-" };
        System.out.println("res " + evalRPN(strings));
    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer> notation = new Stack<>();

        for (String token : tokens) {
            switch (token) {
                case "+":
                    notation.push(notation.pop() + notation.pop());
                    break;
                case "-":
                    int tw = notation.pop(), on = notation.pop();
                    notation.push(on - tw);
                    break;
                case "*":
                    notation.push(notation.pop() * notation.pop());
                    break;
                case "/":
                    int two = notation.pop(), one = notation.pop();
                    notation.push(one / two);
                    break;
                default:
                    notation.push(Integer.parseInt(token));
            }
        }
        return notation.peek();
    }

}
