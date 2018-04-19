/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {

    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        } else if (head.next == null) {
            return head;
        }
        ListNode prev, ptr, next;
        prev = head;
        ptr = prev.next;
        prev.next = null;
        while (ptr.next != null) {
            next = ptr.next;
            ptr.next = prev;
            prev = ptr;
            ptr = next;
        }
        ptr.next = prev;
        return ptr;
    }

}