#include <iostream>
#include <vector>
#include <deque>

using namespace std;

class MonotonicQueue {
public:
    // push element n at back
    void push(int n) {
        while (!data.empty() && data.back() < n) {
            data.pop_back();
        }
        data.push_back(n);
    }

    // return the max value in queue
    int max() {
        return data.front();
    }

    // if front is n, pop it
    void pop(int n) {
        if (!data.empty() && data.front() == n) {
            data.pop_front();
        }
    }

private:
    deque<int> data;
};

class Solution {
public:
    vector<int> maxSlidingWindow(vector<int>& nums, int k) {
        MonotonicQueue window;
        vector<int> res;

        for (int i = 0; i < nums.size(); i++) {
            if (i < k - 1) {
                window.push(nums[i]);
            } else {
                window.push(nums[i]);
                res.push_back(window.max());
                window.pop(nums[i - k + 1]);
            }
        }
        return res;
    }
};

int main() {
    std::cout << "Hello, World!" << std::endl;
    return 0;
}
