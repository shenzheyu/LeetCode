#include <iostream>
#include <vector>

using namespace std;

int rob_line(vector<int> nums) {
    // rob[0] = nums[0]
    int rob_i_prev = nums[0];
    // rob[1] = nums[1]
    int rob_i = max(nums[0], nums[1]);

    for (auto it = nums.begin() + 2; it != nums.end(); it++) {
        int rob_i_temp = rob_i;
        // rob[i] = max(rob[i-1], rob[i-2] + nums[i])
        rob_i = max(rob_i_temp, rob_i_prev + *it);
        // rob[i-2] = rob[i-1]
        rob_i_prev = rob_i_temp;
    }

    return rob_i;
}

int main() {
    vector<int> nums = {2,3,2};

    if (nums.size() == 0) {
        return 0;
    } else if (nums.size() == 1) {
        return nums[0];

    } else if (nums.size() == 2) {
        return max(nums[0], nums[1]);
    }

    vector<int> nums1(nums.begin(), nums.end() - 1);
    vector<int> nums2(nums.begin() + 1, nums.end());

    cout << max(rob_line(nums1), rob_line(nums2)) << endl;

    return 0;
}
