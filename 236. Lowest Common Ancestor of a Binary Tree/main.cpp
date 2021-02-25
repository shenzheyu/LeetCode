#include <iostream>

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution {
public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        // base case 1
        if (root == NULL) {
            return NULL;
        }

        // base case 2
        if (root == p || root == q) {
            return root;
        }

        TreeNode *left = lowestCommonAncestor(root->left, p, q);
        TreeNode *right = lowestCommonAncestor(root->right, p, q);

        if (left == NULL && right == NULL) {
            // case 2
            return NULL;
        } else if (left == NULL && right != NULL) {
            // case 3
            return right;
        } else if (left != NULL && right == NULL) {
            // case 3
            return left;
        } else {
            // case 1
            return root;
        }

    }
};

int main() {
    std::cout << "Hello, World!" << std::endl;
    return 0;
}
