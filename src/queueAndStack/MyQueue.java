package queueAndStack;


 // Implement Queue using Stacks

import java.util.Queue;
import java.util.Stack;

class MyQueue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
        this.stack1 = new Stack<>();
        this.stack2 = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
       while(!stack1.isEmpty()){
           stack2.push(stack1.pop());
       }
       stack2.push(x);
       while(!stack2.isEmpty()) {
           stack1.push(stack2.pop());
       }
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
       return stack1.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        return stack1.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return stack1.isEmpty();
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        System.out.println(queue.peek());
        System.out.println(queue.pop());
        System.out.println(queue.peek());
    }
}
