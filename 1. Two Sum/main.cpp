#include <iostream>
#include <vector>
#include <unordered_map>

using namespace std;

class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {

        // construct map(num, index)
        unordered_multimap<int, int> index;
        for (int i = 0; i < nums.size(); i++) {
            index.insert({nums[i], i});
        }

        for (int i = 0; i < nums.size(); i++) {
            int other = target - nums[i];
            // if other exists and is not nums[i]
            if (index.count(other) && i != index.find(other)->second) {
                return vector({i, index.find(other)->second});
            }
        }

        return vector({0, 0});
    }
};

int main() {

    vector<int> nums = {3, 3};
    int target = 6;

    vector<int> ans = Solution().twoSum(nums, target);

    cout << ans.size() << endl;

    return 0;
}
