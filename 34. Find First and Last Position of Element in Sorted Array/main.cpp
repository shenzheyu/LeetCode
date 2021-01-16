#include <iostream>
#include <vector>

using namespace std;

int low_bound(vector<int> nums, int target) {
    int left = 0;
    int right = nums.size();

    while (left < right) {
        int mid = left + (right - left) / 2;

        if (nums[mid] < target) {
            left = mid + 1;
        } else if (nums[mid] > target) {
            right = mid;
        } else if (nums[mid] == target) {
            right = mid;
        }
    }

    if (left == nums.size() || nums[left] != target) {
        return -1;
    }

    return left;
}

int high_bound(vector<int> nums, int target) {
    int left = 0;
    int right = nums.size();

    while (left < right) {
        int mid = left + (right - left) / 2;

        if (nums[mid] < target) {
            left = mid + 1;
        } else if (nums[mid] > target) {
            right = mid;
        } else if (nums[mid] == target) {
            left = mid + 1;
        }
    }

    left--;

    if (left < 0 || nums[left] != target) {
        return -1;
    }

    return left;
}

int main() {
    vector<int> nums;
    nums.push_back(5);
    nums.push_back(7);
    nums.push_back(7);
    nums.push_back(8);
    nums.push_back(8);
    nums.push_back(10);
//    nums.push_back(1);

    int target = 8;

    vector<int> res;

    if (nums.size() == 0) {
        res =  *(new vector<int>(2, -1));
        return -1;
    }

    res.push_back(low_bound(nums, target));
    res.push_back(high_bound(nums, target));

    cout << res[0] << ' ' << res[1] << endl;

    return 0;
}
