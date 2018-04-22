import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void getIntersectionNodeTest() {
        ListNode listNodeA1, listNodeA2,
                listNodeB1, listNodeB2, listNodeB3,
                listNodeC1, listNodeC2, listNodeC3;
        listNodeA1 = new ListNode(1);
        listNodeA2 = new ListNode(2);
        listNodeB1 = new ListNode(3);
        listNodeB2 = new ListNode(4);
        listNodeB3 = new ListNode(5);
        listNodeC1 = new ListNode(6);
        listNodeC2 = new ListNode(7);
        listNodeC3 = new ListNode(8);
        listNodeA1.next = listNodeA2;
        listNodeA2.next = listNodeC1;
        listNodeB1.next = listNodeB2;
        listNodeB2.next = listNodeB3;
        listNodeB3.next = listNodeC1;
        listNodeC1.next = listNodeC2;
        listNodeC2.next = listNodeC3;
        Assert.assertEquals(listNodeC1, Solution.getIntersectionNode(listNodeA1, listNodeB1));
    }

}
