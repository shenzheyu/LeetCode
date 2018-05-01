public class Solution {

    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int mid;
        while(low < high) {
            mid = (high + low) / 2;
            if(nums[low] < nums[high]) {
                return nums[low];
            }
            if(nums[mid] >= nums[low]) {
                low = mid + 1;
            }else {
                high = mid;
            }
        }
        return nums[low];
    }

}
