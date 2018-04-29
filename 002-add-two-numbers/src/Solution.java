import java.util.List;
import java.util.Stack;

public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null) {
            return new ListNode(0);
        }
        ListNode res = new ListNode(0);
        ListNode cur = res;
        int temp = 0;
        while(l1 != null || l2 != null) {
            if(l1 != null) {
                temp += l1.val;
                l1 = l1.next;
            }
            if(l2 != null) {
                temp += l2.val;
                l2 = l2.next;
            }
            cur.next = new ListNode(temp % 10);
            cur = cur.next;
            temp /= 10;
        }
        if(temp != 0) {
            cur.next = new ListNode(temp);
        }
        return res.next;
    }

}
