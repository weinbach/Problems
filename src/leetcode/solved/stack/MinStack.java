package leetcode.solved.stack;

import java.util.Stack;

public class MinStack {
    //#155 Min Stack
    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(3);
        stack.push(3);
        stack.push(4);
        System.out.println("top: " + stack.top());
        stack.pop();
        System.out.println("min: " + stack.getMin());
        stack.pop();;
        System.out.println("min: " + stack.getMin());
        stack.pop();
        stack.push(4);

        System.out.println("zztop: " + stack.top());
        System.out.println("min: " + stack.getMin());
        stack.push(3);
        System.out.println("top: " + stack.top());
        System.out.println("min: " + stack.getMin());
        stack.pop();
        System.out.println("min: " + stack.getMin());
    }

    Stack<Integer> stack;
    Stack<Integer> minValues;

    int min;
    boolean firstMin = true;

    public MinStack() {
        stack = new Stack<>();
        minValues = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if(firstMin){
            min = x;
            firstMin = false;
        }
        else if(min>x){
            min = x;
        }
        minValues.push(min);
    }

    public void pop() {
        stack.pop();
        minValues.pop();
        if(!minValues.empty())
            min = minValues.peek();
        else
            min = Integer.MAX_VALUE;

    }

    public int top() {
       return stack.peek();
    }

    public int getMin() {
        return minValues.peek();
    }
}

