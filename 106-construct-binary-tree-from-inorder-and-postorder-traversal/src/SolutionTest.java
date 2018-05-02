import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class SolutionTest {

	public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
          return new int[0];
        }
    
        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }
    
    public static String treeNodeToString(TreeNode root) {
        if (root == null) {
            return "[]";
        }
    
        String output = "";
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        while(!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();
    
            if (node == null) {
              output += "null, ";
              continue;
            }
    
            output += String.valueOf(node.val) + ", ";
            nodeQueue.add(node.left);
            nodeQueue.add(node.right);
        }
        return "[" + output.substring(0, output.length() - 2) + "]";
    }

	@Test
	public void buildTreeTest() {
		int[] inorder = stringToIntegerArray("[9,3,15,20,7]");
        int[] postorder = stringToIntegerArray("[9,15,7,20,3]");
            
        TreeNode ret = new Solution().buildTree(inorder, postorder);
            
        String out = treeNodeToString(ret);
            
        System.out.print(out);

        inorder = stringToIntegerArray("[2,1]");
        postorder = stringToIntegerArray("[2,1]");

        ret = new Solution().buildTree(inorder, postorder);

        out = treeNodeToString(ret);

        System.out.print(out);

        inorder = stringToIntegerArray("[1,2,3,4]");
        postorder = stringToIntegerArray("[3,2,4,1]");

        ret = new Solution().buildTree(inorder, postorder);

        out = treeNodeToString(ret);

        System.out.print(out);
	}

}
