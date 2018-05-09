public class Solution {

    public int binarySearch(int[] A, int len, int num) {
        int i = 0;
        int j = len;
        while(i <= j) {
            int mid = (i + j) / 2;
            if(A[mid] > num) {
                j = mid - 1;
            }else if(A[mid] < num) {
                i = mid + 1;
            }else {
                return mid;
            }
        }
        return i;
    }

    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        int[] B = new int[nums.length];
        B[0] = nums[0];
        int len = 0;
        for(int i = 1; i < nums.length; i += 1) {
            if(nums[i] > B[len]) {
                len += 1;
                B[len] = nums[i];
            }else {
                int m = binarySearch(B, len, nums[i]);
                B[m] = nums[i];
            }
        }
        return len + 1;
    }

}
