import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class SolutionTest {

    public static TreeNode stringToTreeNode(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }

        String[] parts = input.split(",");
        String item = parts[0];
        TreeNode root = new TreeNode(Integer.parseInt(item));
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        int index = 1;
        while(!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }

    @Test
    public void isSymmetricTest() {
        TreeNode root1 = stringToTreeNode(new String("[1,2,2,3,4,4,3]"));
        Assert.assertTrue(Solution.isSymmetric(root1));
        TreeNode root2 = stringToTreeNode(new String("[1,2,2,null,3,null,3]"));
        Assert.assertFalse(Solution.isSymmetric(root2));
        TreeNode root3 = stringToTreeNode(new String("[]"));
        Assert.assertTrue(Solution.isSymmetric(root3));
        TreeNode root4 = stringToTreeNode(new String("[1,2]"));
        Assert.assertFalse(Solution.isSymmetric(root4));
    }

}
