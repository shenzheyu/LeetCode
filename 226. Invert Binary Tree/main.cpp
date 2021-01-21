#include <iostream>
#include <queue>

using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;

    TreeNode() : val(0), left(nullptr), right(nullptr) {}

    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}

    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};

// Encodes a tree to a single string.
string serialize(TreeNode* root) {
    if (!root) {
        return "";
    }

    string res;
    queue<TreeNode*> q{{root}};
    while (!q.empty()) {
        auto cur = q.front(); q.pop();
        if (cur) {
            res += to_string(cur->val) + ",";
            q.push(cur->left); // Note: this has no condition check cur->left null or not
            q.push(cur->right); // Note: this has no condition check cur->right null or not
        } else {
            res += "#,";
        }
    }

    return res;
}

// Decodes your encoded data to tree.
TreeNode* deserialize(string data) {
    TreeNode* root = nullptr;
    queue<TreeNode**> q;
    q.push(&root);
    string::iterator first = data.begin();
    while (first != data.end()) {
        TreeNode** pp = q.front();
        if (*first == '#') {
            // *pp = nullptr;
            advance(first, 2);
        } else {
            string::iterator last = find(first, data.end(), ',');
            int val = stoi(string(first, last));
            *pp = new TreeNode(val);
            q.push(&((*pp)->left));
            q.push(&((*pp)->right));
            first = next(last);
        }
        q.pop();
    }
    return root;
}

class Solution {
public:
    TreeNode* invertTree(TreeNode* root) {
        // base case
        if (root == NULL) {
            return NULL;
        }

        // deal with root
        TreeNode *tmp;
        tmp = root->left;
        root->left = root->right;
        root->right = tmp;

        // deal with the child node recursively
        root->left = invertTree(root->left);
        root->right = invertTree(root->right);

        return root;
    }
};

int main() {
    std::cout << "Hello, World!" << std::endl;
    return 0;
}
