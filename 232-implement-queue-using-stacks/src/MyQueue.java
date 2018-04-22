import java.util.Stack;

public class MyQueue {

    Stack<Integer> stack1;
    Stack<Integer> stack2;
    int size;

    /** Initialize your data structure here. */
    public MyQueue() {

        stack1 = new Stack<>();
        stack2 = new Stack<>();
        size = 0;

    }

    /** Push element x to the back of queue. */
    public void push(int x) {

        stack1.push(x);
        size ++;

    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {

        if(stack2.isEmpty()) {
            while(!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        int res = stack2.pop();
        size--;
        return res;

    }

    /** Get the front element. */
    public int peek() {

        if(stack2.isEmpty()) {
            while(!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        int res = stack2.peek();
        return res;

    }

    /** Returns whether the queue is empty. */
    public boolean empty() {

        if(size == 0) {
            return true;
        }
        return false;

    }

}
