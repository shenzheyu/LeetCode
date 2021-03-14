#include <iostream>
#include <vector>
#include <stack>
#include <unordered_map>

using namespace std;

class Solution {
public:
    vector<int> nextGreaterElement(vector<int>& nums1, vector<int>& nums2) {
        stack<int> stack;
        unordered_map<int, int> map;

        // maintain monotonic stack
        // store next greater element for nums2 into map
        for (auto num : nums2) {
            while (!stack.empty() && stack.top() < num) {
                map.insert(pair<int, int>(stack.top(), num));
                stack.pop();
            }
            stack.push(num);
        }

        while (!stack.empty()) {
            map.insert(pair<int, int>(stack.top(), -1));
            stack.pop();
        }

        // iterate nums1 and find the result
        vector<int> res;
        for (auto num : nums1) {
            res.push_back(map.at(num));
        }

        return res;
    }
};

int main() {
    std::cout << "Hello, World!" << std::endl;
    return 0;
}
