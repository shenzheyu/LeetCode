#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        vector<vector<int>> res;
        for (int i = 0; i < nums.size(); i++) {
            vector<vector<int>> tuples = twoSumTarget(nums, i + 1, -nums[i]);
            for (auto tuple : tuples) {
                tuple.push_back(nums[i]);
                res.push_back(tuple);
            }
            while (i < nums.size() - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return res;
    }

private:
    vector<vector<int>> twoSumTarget(vector<int>& nums, int start, int target) {
        int lo = start, hi = nums.size() - 1;
        vector<vector<int>> res;
        while(lo < hi) {
            int left = nums[lo], right = nums[hi];
            int sum = left + right;
            if (target > sum) {
                while (lo < hi && nums[lo] == left) {
                    lo++;
                }
            } else if (target < sum) {
                while (lo < hi && nums[hi] == right) {
                    hi--;
                }
            } else {
                res.push_back({left, right});
                while (lo < hi && nums[lo] == left) {
                    lo++;
                }
                while (lo < hi && nums[hi] == right) {
                    hi--;
                }
            }
        }
        return res;
    }
};

int main() {
    vector<int> nums = {1, -1, -1, 0};
    vector<vector<int>> ans = Solution().threeSum(nums);
    cout << ans.size() << endl;
    return 0;
}
