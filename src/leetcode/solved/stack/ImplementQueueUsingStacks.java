package leetcode.solved.stack;

import java.util.Stack;

public class ImplementQueueUsingStacks {
    //#232 Implement Queue using Stacks

    class MyQueue {

        Stack<Integer> usualStack;
        Stack<Integer> reversedStack;

        public MyQueue() {
            usualStack = new Stack<>();
            reversedStack = new Stack<>();
        }

        public void push(int x) {
            Stack<Integer> temp = new Stack<>();

            temp.push(x);
            while(!usualStack.empty()){
                temp.push(usualStack.pop());
            }
            while(!reversedStack.empty()){
                usualStack.push(reversedStack.pop());
            }
            usualStack.push(x);
            reversedStack = temp;
        }

        public int pop() {
            Stack<Integer> temp = new Stack<>();

            reversedStack.pop();
            while(!reversedStack.empty()){
                temp.push(reversedStack.pop());
            }
            while(!usualStack.empty()){
                reversedStack.push(usualStack.pop());
            }
            usualStack = temp;
            return  reversedStack.pop();
        }

        public int peek() {
            return reversedStack.peek();
        }

        public boolean empty() {
            return reversedStack.empty();
        }
    }
}
