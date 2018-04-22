public class Solution {

    public static int removeDuplicates(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        int res = 1;
        int flag = nums[0];
        int index = 1;
        for(int i : nums) {
            if(i != flag) {
                res++;
                flag = i;
                nums[index] = i;
                index++;
            }
        }
        return res;
    }

}
