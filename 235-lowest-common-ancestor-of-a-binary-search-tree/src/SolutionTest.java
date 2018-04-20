import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void lowestCommonAncestorTest() {
        TreeNode root, t6, t2, t8, t0, t4, t7, t9, t3, t5;
        t0 = new TreeNode(0);
        t7 = new TreeNode(7);
        t9 = new TreeNode(9);
        t3 = new TreeNode(3);
        t5 = new TreeNode(5);
        t4 = new TreeNode(4);
        t2 = new TreeNode(2);
        t8 = new TreeNode(8);
        t6 = new TreeNode(6);
        root = t6;
        t6.left = t2;
        t6.right = t8;
        t2.left = t0;
        t2.right = t4;
        t4.left = t3;
        t4.right = t5;
        t8.left = t7;
        t8.right = t9;
        Assert.assertEquals(t6, Solution.lowestCommonAncestor(root, t2, t8));
        Assert.assertEquals(t2, Solution.lowestCommonAncestor(root, t2, t4));
    }

}
