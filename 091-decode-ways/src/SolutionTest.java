import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void numDecodingsTest() {
        Assert.assertEquals(2, new Solution().numDecodings("12"));
        Assert.assertEquals(3, new Solution().numDecodings("226"));
    }

}
