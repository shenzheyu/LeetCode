import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void hasCycleTest() {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode2;
        Assert.assertTrue(Solution.hasCycle(listNode1));
    }

}
