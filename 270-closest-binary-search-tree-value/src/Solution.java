import java.util.Stack;

public class Solution {

    public static int closestValue(TreeNode root, double target) {
        int res = root.val;
        double min = Math.abs(target - res);
        Stack<TreeNode> stackTemp = new Stack<>();
        while(root != null || !stackTemp.isEmpty()) {
            while(root != null) {
                stackTemp.push(root);
                if(Math.abs(root.val - target) < min) {
                    res = root.val;
                    min = Math.abs(root.val - target);
                }
                root = root.left;
            }
            if(!stackTemp.isEmpty()) {
                root = stackTemp.pop();
                if(Math.abs(root.val - target) < min) {
                    res = root.val;
                    min = Math.abs(root.val - target);
                }
                root = root.right;
            }
        }
        return res;
    }

}
