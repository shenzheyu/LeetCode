import org.junit.Test;

public class SolutionTest {

    @Test
    public void copyRandomListTest() {
        RandomListNode r1 = new RandomListNode(1);
        RandomListNode r2 = new RandomListNode(2);
        RandomListNode r3 = new RandomListNode(3);
        r1.next = r2;
        r2.next = r3;
        r1.random = null;
        r2.random = r3;
        r3.random = r1;
        RandomListNode res = Solution.copyRandomList(r1);
    }

}
