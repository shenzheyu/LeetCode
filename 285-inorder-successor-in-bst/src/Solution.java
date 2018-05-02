public class Solution {

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        int pVal = p.val;
        TreeNode res = null;
        while(root.left != null || root.right != null) {
            if(pVal < root.val && root.left != null) {
                if(root.left.val == pVal) {
                    res = root;
                    break;
                }
                root = root.left;
            }
            if(pVal > root.val && root.right != null) {
                if(root.right.val == pVal) {
                    res = root;
                    break;
                }
                root = root.right;
            }
        }
        return res;
    }

}
