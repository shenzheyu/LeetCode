import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void isValidTest() {
        String input = "()";
        Assert.assertTrue(Solution.isValid(input));
        input = "()[]{}";
        Assert.assertTrue(Solution.isValid(input));
        input = "(]";
        Assert.assertFalse(Solution.isValid(input));
        input = "([)]";
        Assert.assertFalse(Solution.isValid(input));
        input = "{[]}";
        Assert.assertTrue(Solution.isValid(input));
    }

}
