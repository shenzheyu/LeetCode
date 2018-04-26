import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionTest {

    @Test
    public void spiralOrder() {

        int[][] input = new int[3][];
        input[0] = new int[]{1, 2, 3};
        input[1] = new int[]{4, 5, 6};
        input[2] = new int[]{7, 8, 9};
        List<Integer> actual = Solution.spiralOrder(input);
        List<Integer> except = Arrays.asList(1,2,3,6,9,8,7,4,5);
        Assert.assertEquals(except, actual);
        input[0] = new int[]{1, 2, 3, 4};
        input[1] = new int[]{5, 6, 7, 8};
        input[2] = new int[]{9, 10, 11, 12};
        actual = Solution.spiralOrder(input);
        except = Arrays.asList(1,2,3,4,8,12,11,10,9,5,6,7);
        Assert.assertEquals(except, actual);

    }

}
