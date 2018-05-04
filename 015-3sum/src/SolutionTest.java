import org.junit.Test;

import java.util.Iterator;
import java.util.List;

public class SolutionTest {

    @Test
    public void threeSumTest() {
        int[] input = new int[]{-2,0,1,1,2};
        List<List<Integer>> output = new Solution().threeSum(input);
        Iterator<List<Integer>> iterator = output.iterator();
        while(iterator.hasNext()) {
            Iterator<Integer> iterator1 = iterator.next().iterator();
            while(iterator1.hasNext()) {
                System.out.print(iterator1.next());
                System.out.print(' ');
            }
            System.out.print('\n');
        }
    }

}
