#include <iostream>
#include <string>
#include <unordered_map>
#include <vector>

using namespace std;

int main() {

    string s = "baa", p = "aa";

    unordered_map<char, int> need, window;
    for (char c : p) {
        need[c]++;
    }

    int left = 0, right = 0;
    int valid = 0;

    vector<int> res;

    while(right < s.size()) {
        // c is the char adding to window
        char c = s[right];
        // move right side of window
        right++;
        // update window counter and valid
        if (need.count(c)) {
            window[c]++;
            if (window[c] == need[c]) {
                valid++;
            }
        }

        cout << "window: [" << left << "," << right << ")" << endl;

        // when window's length is larger than s's length, shrink window
        while(right - left == p.size()) {
            // update the final result
            if (valid == need.size()) {
                res.push_back(left);
            }
            // d is the char removing from window
            char d = s[left];
            // move left size of window;
            left++;
            // update window counter and valid
            if (need.count(d)) {
                if (window[d] == need[d]) {
                    valid--;
                }
                window[d]--;
            }
        }
    }

    cout << res.size() << endl;

    return 0;
}
