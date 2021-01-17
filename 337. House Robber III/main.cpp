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
    int rob(TreeNode* root) {
        int rob;
        int not_rob;
        dp(root, &rob, &not_rob);
        return max(rob, not_rob);
    }

private:
    void dp(TreeNode* root, int *rob, int *not_rob) {
        if (root == NULL) {
            *rob = 0;
            *not_rob = 0;
            return;
        }

        int left_rob;
        int left_not_rob;
        dp(root->left, &left_rob, &left_not_rob);

        int right_rob;
        int right_not_rob;
        dp(root->right, &right_rob, &right_not_rob);

        *rob = root->val + left_not_rob + right_not_rob;
        *not_rob = max(left_rob, left_not_rob) + max(right_rob, right_not_rob);

        return;
    }
};

int main() {
    Solution s;
    string data = "3,2,3,#,3,#,1,#,#,#,#,";
    TreeNode *root = deserialize(data);
    int ans = s.rob(root);
    cout << ans << endl;
    return 0;
}
