import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void convertToTitleTest() {
        int input1 = 26;
        String res1 = Solution.convertToTitle(input1);
        String exp1 = "Z";
        Assert.assertEquals(exp1, res1);
        int input2 = 28;
        String res2 = Solution.convertToTitle(input2);
        String exp2 = "AB";
        Assert.assertEquals(exp2, res2);
    }

}
