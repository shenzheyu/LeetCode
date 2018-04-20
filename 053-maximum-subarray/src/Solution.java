public class Solution {

    public static int maxSubArray(int[] nums) {
        int curmax = 0;
        int allmax = Integer.MIN_VALUE;
        for(int n : nums) {
            curmax += n;
            if(curmax > allmax) {
                allmax = curmax;
            }
            if(curmax < 0){
                curmax = 0;
            }
        }
        return allmax;
    }

}
