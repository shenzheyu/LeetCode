import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void isPalindromeTest() {
        Assert.assertTrue(Solution.isPalindrome(new String("A man, a plan, a canal: Panama")));
        Assert.assertFalse(Solution.isPalindrome(new String("race a car")));
        Assert.assertFalse(Solution.isPalindrome(new String("0P")));
    }

}
