#include <iostream>
#include <vector>

using namespace std;

int main() {
    vector<int> nums = {2, 1, 1, 2};

    if (nums.size() == 0) {
        return 0;
    } else if (nums.size() == 1) {
            return nums[0];

    } else if (nums.size() == 2) {
        return max(nums[0], nums[1]);
    }

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

    cout << rob_i << endl;

    return 0;
}
