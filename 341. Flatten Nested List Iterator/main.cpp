#include <iostream>
#include <vector>

using namespace std;

class NestedInteger {
public:
  // Return true if this NestedInteger holds a single integer, rather than a nested list.
  bool isInteger() const;

  // Return the single integer that this NestedInteger holds, if it holds a single integer
  // The result is undefined if this NestedInteger holds a nested list
  int getInteger() const;

  // Return the nested list that this NestedInteger holds, if it holds a nested list
  // The result is undefined if this NestedInteger holds a single integer
  const vector<NestedInteger> &getList() const;
};


class NestedIterator {
public:
    NestedIterator(vector<NestedInteger> &nestedList) {
        index = 0;
        for (auto node : nestedList) {
            traverse(node);
        }
    }

    int next() {
        return res[index++];
    }

    bool hasNext() {
        if (index < res.size()) {
            return true;
        }
        return false;
    }

private:
    vector<int> res;
    int index;

    void traverse(NestedInteger root) {
        if (root.isInteger()) {
            // achieve leaf node
            res.push_back(root.getInteger());
            return;
        }

        // iterate subtree
        for (auto subtree : root.getList()) {
            traverse(subtree);
        }
    }
};

int main() {
    std::cout << "Hello, World!" << std::endl;
    return 0;
}
