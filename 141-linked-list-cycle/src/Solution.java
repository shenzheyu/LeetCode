import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static boolean hasCycle(ListNode head) {
        Set<ListNode> nodes = new HashSet<>();
        while(head != null) {
            nodes.add(head);
            head = head.next;
            if(nodes.contains(head)) {
                return true;
            }
        }
        return false;
    }

}
