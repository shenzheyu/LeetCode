import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void searchTest() {
        Assert.assertEquals(4, Solution.search(new int[]{4,5,6,7,0,1,2}, 0));
        Assert.assertEquals(-1, Solution.search(new int[]{4,5,6,7,0,1,2}, 3));
        Assert.assertEquals(-1, Solution.search(new int[]{1,3}, 0));
        Assert.assertEquals(-1, Solution.search(new int[]{1}, 0));
    }

}
