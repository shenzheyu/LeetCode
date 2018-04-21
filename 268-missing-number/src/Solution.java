import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static int missingNumber(int[] nums) {
        Set<Integer> ints = new HashSet<Integer>();
        for(int i : nums){
            ints.add(i);
        }
        for(int i = 0; i < nums.length; i++) {
            if(!ints.contains(i)) {
                return i;
            }
        }
        return nums.length + 1;
    }

}
