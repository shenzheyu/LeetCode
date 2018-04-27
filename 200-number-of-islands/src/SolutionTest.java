import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void numIslandsTest() {
        char[][] input = new char[4][];
        input[0] = new char[]{'1','1','1','1','0'};
        input[1] = new char[]{'1','1','0','1','0'};
        input[2] = new char[]{'1','1','0','0','0'};
        input[3] = new char[]{'0','0','0','0','0'};
        Assert.assertEquals(1, Solution.numIslands(input));
        input[0] = new char[]{'1','1','0','0','0'};
        input[1] = new char[]{'1','1','0','0','0'};
        input[2] = new char[]{'0','0','1','0','0'};
        input[3] = new char[]{'0','0','0','1','1'};
        Assert.assertEquals(3, Solution.numIslands(input));
        input[0] = new char[]{'1','1','1','1','1'};
        input[1] = new char[]{'0','0','1','0','0'};
        input[2] = new char[]{'0','0','1','0','0'};
        input[3] = new char[]{'1','1','1','1','1'};
        Assert.assertEquals(1, Solution.numIslands(input));
    }

}
