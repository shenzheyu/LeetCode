import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void countPrimes() {
        Assert.assertEquals(4, Solution.countPrimes(10));
        Assert.assertEquals(25, Solution.countPrimes(100));
        long startTime = System.currentTimeMillis();
        System.out.println(Solution.countPrimes(1500000));
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }

}
