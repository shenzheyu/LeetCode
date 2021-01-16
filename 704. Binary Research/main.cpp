#include <iostream>
#include <vector>

using namespace std;

int main() {

    vector<int> nums;
    nums.push_back(-1);
    nums.push_back(0);
    nums.push_back(3);
    nums.push_back(5);
    nums.push_back(9);
    nums.push_back(12);

    int target = 2;

    int left = 0, right = nums.size() - 1;

    while (left <= right) {
        int mid = left + (right - left) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] < target) {
            left = mid + 1;
        } else if (nums[mid] > target) {
            right = mid - 1;
        }
    }

    return -1;
}
