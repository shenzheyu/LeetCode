import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class Solution {

    public void flatten(TreeNode root) {
        if(root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        List<TreeNode> list = new ArrayList<>();
        while(root != null || !stack.isEmpty()) {
            while(root != null) {
                list.add(root);
                stack.push(root);
                root = root.left;
            }
            if(!stack.isEmpty()) {
                root = stack.pop();
                root = root.right;
            }
        }
        Iterator<TreeNode> iterator = list.iterator();
        TreeNode prev = iterator.next();
        while(iterator.hasNext()) {
            prev.left = null;
            prev.right = iterator.next();
            prev = prev.right;
        }
        prev.right = null;
    }

}
