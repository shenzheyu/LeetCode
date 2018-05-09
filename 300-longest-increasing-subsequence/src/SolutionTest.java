import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void binarySearchTest() {
        Assert.assertEquals(3, new Solution().binarySearch(new int[]{2, 3, 6, 8, 9, 0, 0}, 4, 7));
    }

    @Test
    public void lengthOfLISTest() {
        Assert.assertEquals(4, new Solution().lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
        Assert.assertEquals(1, new Solution().lengthOfLIS(new int[]{2, 2}));
        Assert.assertEquals(6, new Solution().lengthOfLIS(new int[]{3, 5, 6, 2, 5, 4, 19, 5, 6, 7, 12}));
    }

}
