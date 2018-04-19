import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void titleToNumberTest() {
        String str1 = "AB";
        int exp1 = 28;
        Assert.assertEquals(exp1, Solution.titleToNumber(str1));
        String str2 = "Z";
        int exp2 = 26;
        Assert.assertEquals(exp2, Solution.titleToNumber(str2));
    }
}
