public class Solution {

    public static int search(int[] nums, int target) {
        int n = nums.length;
        if(n == 0) {
            return -1;
        }
        if(n == 1) {
            if(nums[0] == target) {
                return 0;
            }else {
                return -1;
            }
        }
        int d = 0;
        int i;
        if(nums[n - 1] == target) {
            return n - 1;
        }else if(nums[0] == target) {
            return 0;
        }else if(nums[n - 1] > target) {
            i = n - 2;
            d = nums[i + 1] - nums[i];
            while(d > 0) {
                if(nums[i] == target) {
                    return i;
                }else if(nums[i] > target) {
                    i -= 1;
                    if(i < 0) {
                        return -1;
                    }
                    d = nums[i + 1] - nums[i];
                }else if(nums[i] < target) {
                    return -1;
                }
            }
        }else if(nums[0] < target) {
            i = 1;
            d = nums[i] - nums[i - 1];
            while(d > 0) {
                if(nums[i] == target) {
                    return i;
                }else if(nums[i] < target) {
                    i += 1;
                    if(i > n - 1) {
                        return -1;
                    }
                    d = nums[i] - nums[i - 1];
                }else if(nums[i] > target) {
                    return -1;
                }
            }
        }
        return -1;
    }

}
