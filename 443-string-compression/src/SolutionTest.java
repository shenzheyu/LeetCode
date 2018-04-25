import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void compress() {
        char[] str1 = new char[]{'a','a','b','b','c','c','c'};
        Assert.assertEquals(6, Solution.compress(str1));
        char[] str2 = new char[]{'a'};
        Assert.assertEquals(1, Solution.compress(str2));
        char[] str3 = new char[]{'a','b','b','b','b','b','b','b','b','b','b','b','b'};
        Assert.assertEquals(4, Solution.compress(str3));
    }

}
