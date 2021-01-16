#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

vector<vector<int>> res;

void back_track(vector<int> nums, vector<int> track) {
    // stop test
    if (nums.size() == track.size()) {
        res.push_back(track);
        return;
    }

    for (auto it = nums.begin(); it != nums.end(); it++) {
        // remove illegal choice
        if (find(track.begin(), track.end(), *it) != track.end()) {
            continue;
        }

        // do choice
        track.push_back(*it);

        // recursvive
        back_track(nums, track);

        // redo choice
        track.pop_back();
    }
}


int main() {

    vector<int> nums;
    nums.push_back(1);
    nums.push_back(2);
    nums.push_back(3);

    vector<int> track;

    back_track(nums, track);

    cout << res.size() << endl;

    return 0;
}
