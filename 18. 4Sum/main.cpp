#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    vector<vector<int>> fourSum(vector<int>& nums, int target) {
        sort(nums.begin(), nums.end());

        vector<vector<int>> res;
        for (int i = 0; i < nums.size(); i++) {
            vector<vector<int>> triples = threeSumTarget(nums, i + 1, target - nums[i]);
            for (auto triple : triples) {
                triple.push_back(nums[i]);
                res.push_back(triple);
            }
            while (i < nums.size() - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return res;
    }

private:
    vector<vector<int>> threeSumTarget(vector<int>& nums, int start, int target) {
        vector<vector<int>> res;
        for (int i = start; i < nums.size(); i++) {
            vector<vector<int>> tuples = twoSumTarget(nums, i + 1, target - nums[i]);
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
    vector<vector<int>> ans = Solution().fourSum(nums);
    cout << ans.size() << endl;
    return 0;
}
