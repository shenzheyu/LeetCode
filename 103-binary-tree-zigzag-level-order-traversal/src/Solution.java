import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        traverseLayer(root, res, 0);
        return res;
    }

    public static void traverseLayer(TreeNode root, List<List<Integer>> res, int layer) {
        if(root == null) {
            return;
        }
        if(res.size() <= layer) {
            res.add(new ArrayList<Integer>());
        }
        List<Integer> current = res.get(layer);
        if(layer % 2 == 0) {
            current.add(root.val);
        }else {
            current.add(0, root.val);
        }
        traverseLayer(root.left, res, layer + 1);
        traverseLayer(root.right, res, layer + 1);

    }

}
