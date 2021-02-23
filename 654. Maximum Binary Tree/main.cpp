#include <iostream>
#include <vector>

using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};

class Solution {
public:
    TreeNode* constructMaximumBinaryTree(vector<int>& nums) {
        TreeNode *root = build(nums, 0, nums.size() - 1);
        return root;
    }

private:
    // construct tree with nums[lo, hi]
    TreeNode* build(vector<int>& nums, int lo, int hi) {
        // base case
        if (lo > hi) {
            return NULL;
        }

        // find the max value and index in nums
        int rootVal = INT_MIN;
        int rootInd = -1;
        for (int i = lo; i <= hi; i++) {
            if (nums[i] > rootVal) {
                rootVal = nums[i];
                rootInd = i;
            }
        }
        TreeNode *root = new TreeNode(rootVal);

        // construct the left tree and right tree recursively
        root->left = build(nums, lo, rootInd - 1);
        root->right = build(nums, rootInd + 1, hi);

        return root;
    }
};

int main() {
    std::cout << "Hello, World!" << std::endl;
    return 0;
}
