import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class SolutionTest {

    @Test
    public void productExceptSelfTest() {
        Assert.assertTrue(Arrays.equals(new int[]{24,12,8,6},Solution.productExceptSelf(new int[]{1,2,3,4})));
    }

}
