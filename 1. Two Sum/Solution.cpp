//
// Created by shenz on 2018/3/21.
//

#include <vector>

class Solution {
public:
    std::vector<int> twoSum(std::vector<int>& nums, int target) {
        int nums_size = nums.size();
        std::vector<int> ans;
        for(int i = 0; i < nums_size - 1; i++){
            for(int j = i + 1; j < nums_size; j++){
                if(nums[i] + nums[j] == target){
                    ans.push_back(i);
                    ans.push_back(j);
                }
            }
        }
        return ans;
    }
};