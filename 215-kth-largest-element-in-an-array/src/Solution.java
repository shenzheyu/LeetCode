public class Solution {

    public int findMinIndex(int[] nums) {
        int min = nums[0];
        int minIndex = 0;
        for(int i = 1; i < nums.length; i++) {
            if(min > nums[i]) {
                min = nums[i];
                minIndex = i;
                if(min == Integer.MIN_VALUE) {
                    break;
                }
            }
        }
        return minIndex;
    }

    public int findKthLargest(int[] nums, int k) {
        int[] Kth = new int[k];
        int size = 0;
        int minIndex;
        for(int i = 0; i < k; i++) {
            Kth[i] = Integer.MIN_VALUE;
        }
        for(int i = 0; i < nums.length; i++) {
            minIndex = findMinIndex(Kth);
            if(nums[i] > Kth[minIndex]) {
                size++;
                Kth[minIndex] = nums[i];
            }
        }
        int min = Kth[0];
        if(k > size + 1) {
            k = size + 1;
        }
        for(int i = 1; i < k; i++) {
            if(Kth[i] < min) {
                min = Kth[i];
            }
        }
        return min;
    }

}
