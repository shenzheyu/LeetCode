import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

    public static void connect(TreeLinkNode root) {

        if(root == null) {
            return;
        }
        Deque<TreeLinkNode> deque = new ArrayDeque<>();
        deque.addLast(root);
        TreeLinkNode ptr = root;
        int thisNum = 1;
        int nextNum = 0;
        while(!deque.isEmpty()) {
            TreeLinkNode node = deque.pollFirst();
            thisNum -= 1;
            if(node.left != null) {
                deque.addLast(node.left);
                nextNum += 1;
            }
            if(node.right != null) {
                deque.addLast(node.right);
                nextNum += 1;
            }
            if(thisNum == 0) {
                node.next = null;
                thisNum = nextNum;
                nextNum = 0;
            }else {
                node.next = deque.getFirst();
            }

        }

    }

}
