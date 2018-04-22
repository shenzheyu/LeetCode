import java.util.HashSet;
import java.util.Set;

public class Solution {


    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> pathA = new HashSet<>();
        while(headA != null) {
            pathA.add(headA);
            headA = headA.next;
        }
        while(headB != null) {
            if(pathA.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }

}
