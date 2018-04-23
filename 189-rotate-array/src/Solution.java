public class Solution {

    public static void rotate(int[] nums, int k) {
        int[] res = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            res[i] = nums[i];
        }
        for(int i = 0; i < nums.length; i++) {
            nums[(i + k) % nums.length] = res[i];
        }
    }

}
