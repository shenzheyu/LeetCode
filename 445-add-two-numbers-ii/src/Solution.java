import java.util.Iterator;
import java.util.Stack;

public class Solution {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ptr;
        ptr = l1;
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        Stack<Integer> stackSum = new Stack<>();
        while (ptr != null) {
            stack1.push(ptr.val);
            ptr = ptr.next;
        }
        ptr = l2;
        while (ptr != null) {
            stack2.push(ptr.val);
            ptr = ptr.next;
        }
        int temp = stack1.pop() + stack2.pop();
        stackSum.push(temp % 10);
        temp /= 10;
        while (!stack1.isEmpty() && !stack2.isEmpty()){
            temp = stack1.pop() + stack2.pop() + temp;
            stackSum.push(temp % 10);
            temp /= 10;
        }
        while (!stack1.isEmpty()) {
            temp = stack1.pop() + temp;
            stackSum.push(temp % 10);
            temp /= 10;
        }
        while (!stack2.isEmpty()) {
            temp = stack2.pop() + temp;
            stackSum.push(temp % 10);
            temp /= 10;
        }
        if(temp != 0) {
            stackSum.push(temp);
        }
        ListNode res = new ListNode(stackSum.pop());
        ptr = res;
        while (!stackSum.isEmpty()) {
            ptr.next = new ListNode(stackSum.pop());
            ptr = ptr.next;
        }
        return res;
    }

}
