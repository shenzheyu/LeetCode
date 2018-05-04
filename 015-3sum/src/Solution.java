import java.util.*;

public class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ret = new ArrayList<>();
        for(int i = 0; i < nums.length; i += 1) {
            if(i == 0 || nums[i] > nums[i - 1]) {
                int target = -nums[i];
                int left = i + 1;
                int right = nums.length - 1;
                while(left < right) {
                    if(nums[left] + nums[right] < target) {
                        left += 1;
                    }else if(nums[left] + nums[right] > target) {
                        right -= 1;
                    }else {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        ret.add(list);
                        left += 1;
                        right -= 1;
                        while(left < right && nums[left] == nums[left - 1]) {
                            left += 1;
                        }
                        while(left < right && nums[right] == nums[right + 1]) {
                            right -= 1;
                        }
                    }
                }
            }
        }
        return ret;
    }

}
