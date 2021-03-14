#include <iostream>
#include <vector>
#include <stack>

using namespace std;

class Solution {
public:
    vector<int> dailyTemperatures(vector<int>& T) {
        stack<int> stack;   // monotonic stack
        vector<int> res(T.size());  // store result in index

        // push into stack in reverse order
        for (int i = T.size() - 1; i >= 0; i--) {
            while (!stack.empty() && T.at(stack.top()) <= T.at(i)) {
                // remove the smaller one
                stack.pop();
            }
            // stack.top() is index for the next greater elements
            res.at(i) = stack.empty() ? 0 : (stack.top() - i);

            stack.push(i);
        }

        return res;
    }
};

int main() {
    std::cout << "Hello, World!" << std::endl;
    return 0;
}
