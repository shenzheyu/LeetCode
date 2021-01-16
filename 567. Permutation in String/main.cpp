#include <iostream>
#include <string>
#include <unordered_map>

using namespace std;

int main() {

    string s1 = "ab";
    string s2 = "eidbaooo";

    if (s1.size() > s2.size()) {
        return -1;
    }

    unordered_map<char, int> need, window;
    for (char c : s1) {
        need[c]++;
    }

    int left = 0, right = 0;
    int valid = 0;

    for (int i = 0; i < s1.size(); i++) {
        // c is the char adding to window
        char c = s2[right];
        // move the right side of window
        right++;
        // update the window counter and valid
        if (need.count(c)) {
            window[c]++;
            if (window[c] == need[c]) {
                valid++;
            }
        }
    }

    if(valid >= need.size()) {
        return 0;
    }

    while (right < s2.size()) {
        // c is the char adding to window
        char c = s2[right];
        // move the right side of window
        right++;
        // update the window counter and valid
        if (need.count(c)) {
            window[c]++;
            if (window[c] == need[c]) {
                valid++;
            }
        }

//        cout << "window: [" << left << "," << right << ")" << endl;

        // d is the char removing to window
        char d = s2[left];
        // move the left side of window
        left++;
        // update the window counter and valid
        if (need.count(d)) {
            if (window[d] == need[d]) {
                valid--;
            }
            window[d]--;
        }

        if(valid >= need.size()) {
            return 0;
        }
    }

    return -1;
}
