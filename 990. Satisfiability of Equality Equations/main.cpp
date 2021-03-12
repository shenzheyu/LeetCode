#include <iostream>
#include <vector>

using namespace std;

class UF {
public:
    // construct function
    UF(int n) {
        this->_count = n;
        // point parent to self
        // init size as 1
        this->parent = new int[n];
        this->size = new int[n];
        for (int i = 0; i < n; i++) {
            this->parent[i] = i;
            this->size[i] = 1;
        }
    }

    // union p and q
    void _union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) {
            return;
        }

        // connect small tree below big tree
        if (this->size[rootP] < this->size[rootQ]) {
            this->parent[rootP] = rootQ;
        } else {
            this->parent[rootQ] = rootP;
        }

        this->parent[rootP] = rootQ;
        this->_count--;
    }

    // determine whether p an q in the same subset
    bool connected(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        return rootP == rootQ;
    }

    // return the number of subset
    int count() {
        return this->_count;
    }

private:
    int _count;
    int *parent;
    int *size;

    int find(int x) {
        while(this->parent[x] != x) {
            this->parent[x] = this->parent[this->parent[x]];
            x = this->parent[x];
        }
        return x;
    }
};

class Solution {
public:
    bool equationsPossible(vector<string>& equations) {
        // initial uf
        UF *uf = new UF(26);

        // for "==", union them
        for (auto equation : equations) {
            if (equation.at(1) == '=') {
                uf->_union(equation.at(0) - 'a', equation.at(3) - 'a');
            }
        }

        // for "!=", determine their not connected
        for (auto equation : equations) {
            if (equation.at(1) == '!') {
                if (uf->connected(equation.at(0) - 'a', equation.at(3) - 'a')) {
                    return false;
                }
            }
        }

        return true;
    }
};

int main() {
    std::cout << "Hello, World!" << std::endl;
    return 0;
}
