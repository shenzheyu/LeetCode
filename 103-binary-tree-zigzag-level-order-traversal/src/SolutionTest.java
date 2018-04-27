import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.*;

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
        TreeNode root = stringToTreeNode(new String("[3,9,20,null,null,15,7]"));
        List<List<Integer>> exp = new ArrayList<>();
        exp.add(Arrays.asList(3));
        exp.add(Arrays.asList(20, 9));
        exp.add(Arrays.asList(15, 7));
        Assert.assertTrue(exp.equals(Solution.zigzagLevelOrder(root)));
    }

}
