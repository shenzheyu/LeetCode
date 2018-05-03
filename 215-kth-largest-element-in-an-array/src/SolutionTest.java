import org.junit.Test;

public class SolutionTest {

    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    @Test
    public void findKthLargestTest() {
        int[] nums = stringToIntegerArray("[3,2,1,5,6,4]");
        int k = Integer.parseInt("2");

        int ret = new Solution().findKthLargest(nums, k);

        String out = String.valueOf(ret);

        System.out.print(out);
    }

}
