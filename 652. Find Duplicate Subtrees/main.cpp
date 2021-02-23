#include <iostream>
#include <vector>
#include <unordered_map>
#include <string>

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
    vector<TreeNode*> findDuplicateSubtrees(TreeNode* root) {
        vector<TreeNode*> res; // contain the nodes of duplicated subtrees
        unordered_map<string, int> mem; // contain the times for each subtree
        traverse(res, mem, root);

        return res;
    }

private:
    string traverse(vector<TreeNode*>& res, unordered_map<string, int>& mem, TreeNode* root) {
        // base case
        if (root == NULL) {
            return "#";
        }

        string left = traverse(res, mem, root->left);
        string right = traverse(res, mem, root->right);

        // serialize subtree in post order
        string tree = left + ',' + right + ',' + to_string(root->val);

        // record the appearance time of subtree
        mem[tree]++;

        // if and only if subtree appeases twice, add it to add it into res
        if (mem[tree] == 2) {
            res.push_back(root);
        }

        return tree;
    }
};

int main() {
    std::cout << "Hello, World!" << std::endl;
    return 0;
}
