import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) {
            return null;
        }
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode ptr = head;
        RandomListNode res, resptr;
        res = new RandomListNode(head.label);
        resptr = res;
        map.put(ptr, resptr);
        while(ptr.next != null) {
            ptr = ptr.next;
            resptr.next = new RandomListNode(ptr.label);
            resptr = resptr.next;
            map.put(ptr, resptr);
        }
        ptr = head;
        resptr = res;
        while(ptr != null) {
            resptr.random = map.get(ptr.random);
            resptr = resptr.next;
            ptr = ptr.next;
        }
        return res;
    }

}
