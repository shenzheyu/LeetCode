#include <iostream>
#include <string>
#include <vector>
#include <sstream>

using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Codec {
public:

    // Encodes a tree to a single string.
    string serialize(TreeNode* root) {
        ostringstream oss;
        serialize(root, oss);
        return oss.str();
    }

    // Decodes your encoded data to tree.
    TreeNode* deserialize(string data) {
        istringstream iss(data);
        return deserialize(iss);
    }

private:
    void serialize(TreeNode* root, ostringstream & oss) {
        if (root == NULL) {
            oss << "#" << ",";
            return;
        }

        oss << root->val << ",";

        serialize(root->left, oss);
        serialize(root->right, oss);
    }

    TreeNode* deserialize(istringstream& iss) {
        // first element in array is the root node
        string first;
        getline(iss, first, ',');

        if (first == "") {
            return NULL;
        }

        if (first == "#") {
            return NULL;
        }

        TreeNode *root = new TreeNode(stoi(first));

        root->left = deserialize(iss);
        root->right = deserialize(iss);

        return root;
    }
};

int main() {
    string data = "1,2,3,#,#,4,5,";
    TreeNode *root = Codec().deserialize(data);
    data = Codec().serialize(root);

    cout << data << endl;

    return 0;
}
