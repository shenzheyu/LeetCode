public class Solution {

    public static void connect(TreeLinkNode root) {

        TreeLinkNode tempChild;
        TreeLinkNode currentChild;
        while(root != null) {
            tempChild = new TreeLinkNode(0);
            currentChild = tempChild;
            while(root != null) {
                if(root.left != null) {
                    currentChild.next = root.left;
                    currentChild = currentChild.next;
                }
                if(root.right != null) {
                    currentChild.next = root.right;
                    currentChild = currentChild.next;
                }
                root = root.next;
            }
            root = tempChild.next;
        }

    }

}
