import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void rotateTest() {
        int[] nums1 = new int[]{1,2,3,4,5,6,7};
        int[] exp1 = new int[]{5,6,7,1,2,3,4};
        Solution.rotate(nums1, 3);
        for(int i = 0; i < exp1.length; i++) {
            Assert.assertEquals(exp1[i], nums1[i]);
        }
        int[] nums2 = new int[]{1,2,3,4,5,6};
        int[] exp2 = new int[]{6,1,2,3,4,5};
        Solution.rotate(nums2, 1);
        for(int i = 0; i < exp2.length; i++) {
            Assert.assertEquals(exp2[i], nums2[i]);
        }
        int[] nums3 = new int[]{1,2};
        int[] exp3 = new int[]{2,1};
        Solution.rotate(nums3, 1);
        for(int i = 0; i < exp3.length; i++) {
            Assert.assertEquals(exp3[i], nums3[i]);
        }
    }

}
