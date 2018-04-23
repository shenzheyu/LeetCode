import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void hammingWeightTest() {
        Assert.assertEquals(3,Solution.hammingWeight(11));
        Assert.assertEquals(1,Solution.hammingWeight(2048));
    }

}
