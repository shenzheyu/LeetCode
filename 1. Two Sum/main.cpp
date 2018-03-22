#include <iostream>
#include <vector>
#include "Solution.cpp"

int main() {
    Solution solution;
    std::vector<int> nums;
    nums.push_back(2);
    nums.push_back(7);
    nums.push_back(11);
    nums.push_back(15);
    int target = 9;
    std::vector<int> ans = solution.twoSum(nums, target);
    std::cout << ans[0] << ", " << ans[1] << std::endl;
    return 0;
}