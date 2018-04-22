import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void removeDuplicatesTest() {
        int[] nums1 = new int[]{1,1,2};
        int[] nums2 = new int[]{0,0,1,1,1,2,2,3,3,4};
        Assert.assertEquals(2, Solution.removeDuplicates(nums1));
        Assert.assertEquals(5, Solution.removeDuplicates(nums2));
    }

}
