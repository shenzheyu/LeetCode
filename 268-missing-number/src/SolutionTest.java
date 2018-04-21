import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void missingNumberTest() {
        Assert.assertEquals(2, Solution.missingNumber(new int[]{3,0,1}));
        Assert.assertEquals(8, Solution.missingNumber(new int[]{9,6,4,2,3,5,7,0,1}));
    }

}
