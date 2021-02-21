#include <iostream>

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
    void flatten(TreeNode* root) {
        if (root == NULL) {
            return;
        }

        // flatten the left tree and the right tree
        flatten(root->left);
        flatten(root->right);

        // connect the right tree below the left tree
        TreeNode *left = root->left;
        TreeNode *right = root->right;
        if (left != NULL) {
            TreeNode *p = left;
            while (p->right != NULL) {
                p = p->right;
            }
            p->right = right;
        } else {
            left = right;
        }


        // take the left tree as the right tree
        root->left = NULL;
        root->right = left;
    }
};

int main() {
    std::cout << "Hello, World!" << std::endl;
    return 0;
}
