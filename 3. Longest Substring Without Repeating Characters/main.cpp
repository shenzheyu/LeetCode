#include <iostream>
#include <string>
#include <unordered_map>

using namespace std;

int main() {
    string s = "abcabcbb";

    unordered_map<char, int> window;

    int left = 0, right = 0;
    bool valid = true;

    int length = 0;

    while (right < s.size()) {
        // c is the char adding to window
        char c = s[right];
        // move right side of window
        right++;
        // update window counter and valid
        window[c]++;
        if (window[c] > 1) {
            valid = false;
        }

        while (!valid) {
            // d is the char removing from window
            char d = s[left];
            // move left side of window
            left++;
            // update window counter and valid
            window[d]--;
            if (window[d] == 1) {
                valid = true;
            }
        }

        // update the final result
        if (length < right - left) {
            length = right - left;
        }

    }

    cout << length << endl;

    return 0;
}
