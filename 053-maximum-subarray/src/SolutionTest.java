import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void maxSubArrayTest() {
        int[] arr = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        Assert.assertEquals(6, Solution.maxSubArray(arr));
    }

}
