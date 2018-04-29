public class Solution {

	public static void sortColors(int[] nums) {
	    if(nums.length <= 1) {
	        return;
        }
        int zeroNum = 0;
        int twoNum = 0;
        for(int i = 0; i < nums.length - twoNum; i++) {
            while(nums[nums.length - twoNum - 1] == 2) {
                twoNum += 1;
                if(twoNum >= nums.length - 1) {
                    break;
                }
            }
            if(nums[i] == 2) {
                if(i < nums.length - twoNum - 1) {
                    swap(nums, nums.length - twoNum - 1, i);
                }
                twoNum += 1;
            }
            if(nums[i] == 0) {
                if(zeroNum < i) {
                    swap(nums, zeroNum, i);
                }
                zeroNum += 1;
            }
        }
    }

    public static void swap(int[] nums, int a, int b) {
	    int temp = nums[a];
	    nums[a] = nums[b];
	    nums[b] = temp;
    }

}
