import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void longestPalindrome() {
        Assert.assertTrue("bab".equals(Solution.longestPalindrome("babad")));
        Assert.assertTrue("bb".equals(Solution.longestPalindrome("bb")));
        Assert.assertTrue("b".equals(Solution.longestPalindrome("b")));
        Assert.assertTrue("bb".equals(Solution.longestPalindrome("cbbd")));
    }

}
