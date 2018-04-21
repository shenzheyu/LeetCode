import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void romanToIntTest() {
        Assert.assertEquals(3, Solution.romanToInt(new String("III")));
        Assert.assertEquals(4, Solution.romanToInt(new String("IV")));
        Assert.assertEquals(9, Solution.romanToInt(new String("IX")));
        Assert.assertEquals(58, Solution.romanToInt(new String("LVIII")));
        Assert.assertEquals(1994, Solution.romanToInt(new String("MCMXCIV")));
    }

}
