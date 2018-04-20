import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test(timeout = 3000)
    public void mergeTwoListsTest() {
        ListNode listNode11 = new ListNode(1);
        ListNode listNode12 = new ListNode(2);
        ListNode listNode13 = new ListNode(4);
        listNode11.next = listNode12;
        listNode12.next = listNode13;
        ListNode listNode21 = new ListNode(1);
        ListNode listNode22 = new ListNode(3);
        ListNode listNode23 = new ListNode(4);
        listNode21.next = listNode22;
        listNode22.next = listNode23;
        ListNode res = Solution.mergeTwoLists(listNode11, listNode21);
        int[] exp = new int[]{1, 1, 2, 3, 4, 4};
        for(int i = 0; i < 6; i++) {
            Assert.assertEquals(exp[i], res.val);
            res = res.next;
        }

    }

}
