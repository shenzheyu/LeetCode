#include <iostream>
#include <vector>
#include <stack>

using namespace std;

class Solution {
public:
    vector<int> nextGreaterElements(vector<int>& nums) {
        stack<int> stack;   // monotonic stack
        vector<int> res(nums.size());   // store result in value
        int n = nums.size();

        // push into stack in reverse order
        // pretend the length of array doubled
        // use mod to get the real index
        for (int i = 2 * n - 1; i >= 0 ; i--) {
            while (!stack.empty() && stack.top() <= nums.at(i % n)) {
                // remove the smaller one
                stack.pop();
            }
            // stack.top() is the next greater elements
            res.at(i % n) = stack.empty() ? -1 : stack.top();

            stack.push(nums.at(i % n));
        }

        return res;
    }
};

int main() {
    std::cout << "Hello, World!" << std::endl;
    return 0;
}
