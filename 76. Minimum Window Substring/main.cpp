#include <iostream>
#include <string>
#include <unordered_map>

using namespace std;

int main() {

    string s = "ADOBECODEBANC";
    string t = "ABC";

    unordered_map<char, int> need, window;
    for (char c : t) {
        need[c]++;
    }

    int left = 0, right = 0;
    int valid = 0;

    int min_window_size = INT_MAX;
    string min_window;

    while (right < s.size()) {
        // c is the char adding to window
        char c = s[right];
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

        while(valid >= need.size()) {
            // d is the char removing from the window
            char d = s[left];
            // move the left side of window
            left++;
            // update the window counter and valid
            if (need.count(d)) {
                if (window[d] == need[d]) {
                    valid--;
                }
                window[d]--;
            }
            if (right - left + 1 < min_window_size) {
                min_window_size = right - left + 1;
                min_window = s.substr(left - 1, min_window_size);
            }
        }
    }

    if (min_window_size == INT_MAX) {
        min_window = "";
    }

    cout << min_window << endl;



    return 0;
}
