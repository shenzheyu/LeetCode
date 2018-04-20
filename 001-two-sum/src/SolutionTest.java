import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void twoSumTest() {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        int[] exp = new int[]{0, 1};
        for(int i = 0; i < exp.length; i++) {
            Assert.assertEquals(exp[i], Solution.twoSum(nums, target)[i]);
        }
    }


}
