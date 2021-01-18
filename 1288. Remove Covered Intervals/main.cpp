#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

class Solution {
public:
    int removeCoveredIntervals(vector<vector<int>>& intervals) {
        // sort intervals
        sort(intervals.begin(), intervals.end(), compare);

        int left = (*intervals.begin())[0];
        int right = (*intervals.begin())[1];
        int res = intervals.size();

        for (auto it = intervals.begin() + 1; it != intervals.end(); it++) {
            // case 1
            if ((*it)[0] >= left && (*it)[1] <= right) {
                res--;
            }

            // case 2
            if ((*it)[0] >= left && (*it)[1] > right) {
                right = (*it)[1];
            }

            // case 3
            if ((*it)[0] >= right) {
                left = (*it)[0];
                right = (*it)[1];
            }

        }

        return res;
    }


private:
    static bool compare(const vector<int> interval_1, const vector<int> interval_2) {
        if (interval_1[0] > interval_2[0]) {
            return false;
        } else if (interval_1[0] < interval_2[0]) {
            return true;
        } else if (interval_1[0] == interval_2[0]) {
            if (interval_1[1] <= interval_2[1]) {
                return false;
            }
        }
        return true;
    }
};

int main() {

    vector<vector<int>> intervals = {{1, 2}, {3, 6}, {2, 8}};

    int ans = Solution().removeCoveredIntervals(intervals);

    cout << ans << endl;

    return 0;
}
