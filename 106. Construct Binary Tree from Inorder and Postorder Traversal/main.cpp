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
    TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder) {
        TreeNode *root = build(inorder, 0, inorder.size() - 1, postorder, 0, postorder.size() - 1);
        return root;
    }

private:
    TreeNode* build(vector<int>& inorder, int inStart, int inEnd, vector<int>& postorder, int postStart, int postEnd) {
        // base case
        if (inStart > inEnd && postStart > postEnd) {
            return NULL;
        }

        // root value is the last element in postorder
        int rootVal = postorder[postEnd];
        TreeNode *root = new TreeNode(rootVal);

        // find the index of root value in inorder
        int index = -1;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootVal) {
                index = i;
                break;
            }
        }

        // calculate the leftSize
        int leftSize = index - inStart;

        root->left = build(inorder, inStart, index - 1, postorder, postStart, postStart + leftSize - 1);
        root->right = build(inorder, index + 1, inEnd, postorder, postStart + leftSize, postEnd - 1);

        return root;
    }
};

int main() {
    std::cout << "Hello, World!" << std::endl;
    return 0;
}
