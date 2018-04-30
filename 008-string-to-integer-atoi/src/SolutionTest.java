import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void myAtoi() {
        Assert.assertEquals(42, Solution.myAtoi("42"));
        Assert.assertEquals(-42, Solution.myAtoi("   -42"));
        Assert.assertEquals(4193, Solution.myAtoi("4193 with words"));
        Assert.assertEquals(0, Solution.myAtoi("words and 987"));
        Assert.assertEquals(-2147483648, Solution.myAtoi("-91283472332"));
    }

}
