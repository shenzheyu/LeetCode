import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void deleteNodeTest() {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        Solution.deleteNode(listNode3);
        int[] exp = new int[]{1, 2, 4};
        for(int i = 0; i < 3; i++) {
            Assert.assertEquals(exp[i], listNode1.val);
            listNode1 = listNode1.next;
        }
    }

}
