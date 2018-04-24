import java.util.Stack;

public class Solution {

    public static void getLeftStack(TreeNode root, Stack<TreeNode> stack) {
        Stack<TreeNode> stackTemp = new Stack<>();
        stack.push(root);
        while(root != null || !stackTemp.isEmpty()) {
            while(root != null) {
                stackTemp.push(root);
                root = root.left;
                stack.push(root);
            }
            if(!stack.isEmpty()) {
                root = stackTemp.pop();
                root = root.right;
                stack.push(root);
            }
        }
    }

    public static void getRightStack(TreeNode root, Stack<TreeNode> stack) {
        Stack<TreeNode> stackTemp = new Stack<>();
        stack.push(root);
        while(root != null || !stackTemp.isEmpty()) {
            while(root != null) {
                stackTemp.push(root);
                root = root.right;
                stack.push(root);
            }
            if(!stack.isEmpty()) {
                root = stackTemp.pop();
                root = root.left;
                stack.push(root);
            }
        }
    }

    public static boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return true;
        }
        Stack<TreeNode> leftStack = new Stack<>();
        Stack<TreeNode> rightStack = new Stack<>();
        getLeftStack(root.left, leftStack);
        getRightStack(root.right, rightStack);
        boolean res = true;
        while(!leftStack.isEmpty() && !rightStack.isEmpty()) {
            TreeNode left = leftStack.pop();
            TreeNode right = rightStack.pop();
            if(left == null) {
                if(right == null) {
                    continue;
                }else{
                    res = false;
                    break;
                }
            }else if (right == null) {
                if(left == null) {
                    continue;
                }else {
                    res = false;
                    break;
                }
            }else {
                if(left.val != right.val) {
                    res = false;
                    break;
                }
            }

        }
        if(!(leftStack.isEmpty() && rightStack.isEmpty())) {
            res = false;
        }
        return res;
    }

}
