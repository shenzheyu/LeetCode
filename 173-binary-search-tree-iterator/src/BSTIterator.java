import java.util.*;

public class BSTIterator {

    private Stack<TreeNode> stack;
    private Queue<Integer> queue = new LinkedList<>();

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        while(root != null || !stack.isEmpty()) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            queue.add(root.val);
            root = root.right;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if(!queue.isEmpty()) {
            return true;
        }
        return false;
    }

    /** @return the next smallest number */
    public int next() {
        return queue.poll();
    }

}
