import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

	@Test
	public void sortColors() {
		int[] input = new int[]{2,0,2,1,1,0};
		Solution.sortColors(input);
        input = new int[]{0,1,0};
        Solution.sortColors(input);
        input = new int[]{2,2,0};
        Solution.sortColors(input);
        input = new int[]{1,2,0};
        Solution.sortColors(input);
	}


}
