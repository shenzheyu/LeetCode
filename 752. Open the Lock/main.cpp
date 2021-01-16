#include <iostream>
#include <string>
#include <queue>
#include <set>
#include <vector>
#include <algorithm>

using namespace std;

char get_up(char c) {
    char res;
    if (c == '9') {
        res = '0';
    } else {
        res = c + 1;
    }
    return res;
}

char get_down(char c) {
    char res;
    if (c == '0') {
        res = '9';
    } else {
        res = c - 1;
    }
    return res;
}

vector<string> get_adj(string str) {
    vector<string> res;

    for (int i = 0; i < str.length(); i++) {
        char c = str.at(i);
        string before = str.substr(0, i);
        string after = str.substr(i + 1, str.length());
        res.push_back(before + get_up(c) + after);
        res.push_back(before + get_down(c) + after);
    }

    return res;
}

int main() {
    vector<string> deadends;
    deadends.push_back("0201");
    deadends.push_back("0101");
    deadends.push_back("0102");
    deadends.push_back("1212");
    deadends.push_back("2002");

    string target = "0202";

    string start = "0000";

    queue<string> q;
    set<string> visited;

    q.push(start);
    visited.insert(start);
    int turn = 0;

    while(q.size() != 0) {
        int sz = (int)q.size();
        for (int i = 0; i < sz; i++) {
            string cur = q.front();
            q.pop();
            if (find(deadends.begin(), deadends.end(), cur) != deadends.end()) {
                continue;
            }
            if (cur.compare(target) == 0) {
                cout << turn << endl;
                return 0;
            }
            for (string adj : get_adj(cur)) {
                if (visited.find(adj) == visited.end()) {
                    q.push(adj);
                    visited.insert(adj);
                }
            }
        }
        turn++;
    }

    cout << -1 << endl;
    return 0;
}
