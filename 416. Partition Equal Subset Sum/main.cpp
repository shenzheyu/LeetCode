#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    bool canPartition(vector<int>& nums) {

        int sum = 0;
        for (auto num : nums) {
            sum += num;
        }

        if (sum % 2 == 1) {
            return false;
        }

        // dp[i][0] = true, dp[i][j] = false
        vector<bool> dp(sum / 2 + 1, false);
        dp[0] = true;

        // dp[i][j] = dp[i-1][j] or dp[i-1][j-nums[i]]
        for (auto num: nums) {
            // traverse j reversely to avoid effect on other value
            for (int j = sum / 2 + 1; j >= 0; j--) {
                if (j >= num) {
                    dp[j] = dp[j] || dp[j - num];
                }
            }
        }

        return dp[sum / 2];
    }
};

int main() {
    vector<int> nums = {1,2,5};
    bool ans = Solution().canPartition(nums);
    cout << ans << endl;
    return 0;
}
