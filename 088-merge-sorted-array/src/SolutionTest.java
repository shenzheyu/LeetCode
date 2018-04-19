import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void mergeTest() {
        int[] a = new int[]{1, 2, 3, 0, 0, 0};
        int[] b = new int[]{2, 5, 6};
        int[] exp = new int[]{1, 2, 2, 3, 5, 6};
        Solution.merge(a, 3, b, 3);
        for(int i = 0; i < exp.length; i++) {
            Assert.assertEquals(exp[i], a[i]);
        }
    }

}
