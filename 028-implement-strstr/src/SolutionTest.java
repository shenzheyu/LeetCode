import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void strStrTest() {
        Assert.assertEquals(2, Solution.strStr(new String("hello"), new String("ll")));
        Assert.assertEquals(-1, Solution.strStr(new String("aaaaa"), new String("bba")));
        Assert.assertEquals(0, Solution.strStr(new String("hello"), new String("")));
        Assert.assertEquals(0,Solution.strStr(new String("a"), new String("a")));
    }

}
