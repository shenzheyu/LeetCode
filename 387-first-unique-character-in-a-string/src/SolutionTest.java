import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void firstUniqCharTest() {
        Assert.assertEquals(0, Solution.firstUniqChar(new String("leetcode")));
        Assert.assertEquals(2, Solution.firstUniqChar(new String("loveleetcode")));
    }

}
