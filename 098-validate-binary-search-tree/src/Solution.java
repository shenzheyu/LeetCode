public class Solution {

    public boolean isValidBSTWithRange(TreeNode root, long min, long max) {
        if(root == null) {
            return true;
        }
        if(root.val >= max) {
            return false;
        }
        if(root.val <= min) {
            return false;
        }
        if(root.left != null) {
            if(!isValidBSTWithRange(root.left, min, root.val)) {
                return false;
            }
        }
        if(root.right != null) {
            if(!isValidBSTWithRange(root.right, root.val, max)) {
                return false;
            }
        }
        return true;
    }

    public boolean isValidBST(TreeNode root) {
        if(root == null) {
            return true;
        }
        if(root.left != null) {
            if(!isValidBSTWithRange(root.left, Long.MIN_VALUE, root.val)) {
                return false;
            }
        }
        if(root.right != null) {
            if(!isValidBSTWithRange(root.right, root.val, Long.MAX_VALUE)) {
                return false;
            }
        }
        return true;
    }

}
