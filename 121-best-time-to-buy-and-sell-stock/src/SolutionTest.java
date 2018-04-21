import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void maxProfitTest() {
        int[] input1 = new int[]{7,1,5,3,6,4};
        Assert.assertEquals(5, Solution.maxProfit(input1));
        int[] input2 = new int[]{7,6,4,3,1};
        Assert.assertEquals(0, Solution.maxProfit(input2));
    }

}
