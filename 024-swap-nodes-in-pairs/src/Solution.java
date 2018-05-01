public class Solution {

    public ListNode swapPairs(ListNode head) {
        if(head == null) {
            return null;
        }

        if(head.next == null) {
            return head;
        }

        ListNode res = new ListNode(0);
        ListNode ptr = res;
        ListNode temp;

        while(head.next != null && head.next.next != null) {
            ptr.next = head.next;
            temp = head.next.next;
            ptr.next.next = head;
            ptr = ptr.next.next;
            head = temp;
            ptr.next = head;
        }

        if(head.next != null) {
            ptr.next = head.next;
            head.next.next = head;
            head.next = null;
        }

        return res.next;
    }

}
