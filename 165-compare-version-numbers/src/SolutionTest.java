import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void compareVersionTest() {
        String version1 = "0.1";
        String version2 = "1.1";
        Assert.assertEquals(-1, new Solution().compareVersion(version1, version2));
        version1 = "1.0.1";
        version2 = "1";
        Assert.assertEquals(1, new Solution().compareVersion(version1, version2));
        version1 = "7.5.2.4";
        version2 = "7.5.3";
        Assert.assertEquals(-1, new Solution().compareVersion(version1, version2));
    }

}
