#include <iostream>
#include <math.h>

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
    int countNodes(TreeNode* root) {
        if (root == NULL) {
            return 0;
        }

        // record the height for left and right tree
        int hl = 0, hr = 0;
        TreeNode *left = root, *right = root;

        while (left != NULL) {
            left = left->left;
            hl++;
        }

        while (right != NULL) {
            right = right->right;
            hr++;
        }

        if (hl == hr) {
            // perfect binary tree
            return pow(2, hl) - 1;
        }

        // normal binary tree
        return 1 + countNodes(root->left) + countNodes(root->right);
    }
};

int main() {
    TreeNode *root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(6), NULL));
    int num = Solution().countNodes(root);
    cout << num << endl;
    return 0;
}
