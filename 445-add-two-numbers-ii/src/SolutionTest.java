import org.junit.Test;

public class SolutionTest {

    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static ListNode stringToListNode(String input) {
        // Generate array from the input
        int[] nodeValues = stringToIntegerArray(input);

        // Now convert that list into linked list
        ListNode dummyRoot = new ListNode(0);
        ListNode ptr = dummyRoot;
        for(int item : nodeValues) {
            ptr.next = new ListNode(item);
            ptr = ptr.next;
        }
        return dummyRoot.next;
    }

    public static String listNodeToString(ListNode node) {
        if (node == null) {
            return "[]";
        }

        String result = "";
        while (node != null) {
            result += Integer.toString(node.val) + ", ";
            node = node.next;
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    @Test
    public void addTwoNumbersTest() {
        ListNode l1 = stringToListNode("[7,2,4,3]");
        ListNode l2 = stringToListNode("[5,6,4]");
        ListNode ret = new Solution().addTwoNumbers(l1, l2);
        String out = listNodeToString(ret);
        System.out.println(out);
        l1 = stringToListNode("[3,9,9,9,9,9,9,9,9,9]");
        l2 = stringToListNode("[7]");
        ret = new Solution().addTwoNumbers(l1, l2);
        out = listNodeToString(ret);
        System.out.println(out);
        l1 = stringToListNode("[5]");
        l2 = stringToListNode("[5]");
        ret = new Solution().addTwoNumbers(l1, l2);
        out = listNodeToString(ret);
        System.out.println(out);
    }

}
