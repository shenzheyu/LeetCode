import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

    public void traverseLayer(TreeNode root, List<List<Integer>> res, int level) {
        if(root == null) {
            return;
        }
        if(res.size() <= level) {
            res.add(new ArrayList<>());
        }
        List<Integer> current = res.get(level);
        current.add(root.val);
        traverseLayer(root.left, res, level + 1);
        traverseLayer(root.right, res, level + 1);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        traverseLayer(root, res, 0);
        return res;
    }

}
