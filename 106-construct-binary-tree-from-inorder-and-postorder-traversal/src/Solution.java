public class Solution {

	public TreeNode buildTree(int[] inorder, int[] postorder) {
		TreeNode root = null;
		if(inorder.length != 0) {
			root = buildSubTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
		}
        return root;
    }

    public TreeNode buildSubTree(int[] inorder, int instart, int inend, int[] postorder, int poststart, int postend) {
        TreeNode root = new TreeNode(postorder[postend]);
        int pos = instart;
        for(int i = instart; i <= inend; i++) {
        	if(inorder[i] == postorder[postend]) {
        		pos = i;
        		break;
        	}
        }
        int leftLength = pos - instart;
        int rightLength = inend - pos;
        if(leftLength > 0) {
        	root.left = buildSubTree(inorder, instart, pos - 1, postorder, poststart, poststart + leftLength - 1);
        }
        if(rightLength > 0) {
        	root.right = buildSubTree(inorder, pos + 1, inend, postorder, poststart + leftLength, postend - 1);
        }
        return root;
    }

}
