public class SolutionTest {

    public static void reverseListTest () {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = null;
        ListNode listNode = listNode1;
        ListNode listReverse = Solution.reverseList(listNode);
        while (listReverse != null) {
            int n = 3;
            System.out.print(listReverse.val);
            System.out.print(' ');
            listReverse = listReverse.next;
            n--;
        }
    }

    public static void main (String[] args) {
        reverseListTest();
    }


}
