package leetcode.solved.stack;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueue {
    //#225 Implement Stack using Queues

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.top());
        System.out.println(stack.pop());
        System.out.println(stack.empty());
    }

    static class MyStack {
        Queue<Integer> usualQueue;
        Queue<Integer> reversedQueue;
        int size =  0;

        public MyStack() {
            usualQueue = new LinkedList<>();
            reversedQueue = new LinkedList<>();
        }

        public void push(int x) {
            Queue<Integer> temp = new LinkedList<>();
            usualQueue.add(x);
            temp.add(x);
            while(!reversedQueue.isEmpty()){
                temp.add(reversedQueue.poll());
            }
            reversedQueue = temp;
            size++;
        }

        public int pop() {
            size--;
            Queue<Integer> temp = new LinkedList<>();
            for(int i=0;i<size;i++)
                temp.add(usualQueue.poll());
            usualQueue = temp;

            return reversedQueue.poll();
        }

        public int top() {
            return reversedQueue.peek();
        }

        public boolean empty() {
            return usualQueue.isEmpty();
        }
    }
}
