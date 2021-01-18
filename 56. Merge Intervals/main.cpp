#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

class Solution {
public:
    vector<vector<int>> merge(vector<vector<int>>& intervals) {
        // sort intervals
        sort(intervals.begin(), intervals.end(), compare);

        int left = (*intervals.begin())[0];
        int right = (*intervals.begin())[1];
        vector<vector<int>> res;

        for (auto it = intervals.begin() + 1; it != intervals.end(); it++) {
            // extend right
            if ((*it)[0] <= right && (*it)[1] >= right) {
                right = (*it)[1];
            }

            // next merged interval
            if ((*it)[0] > right) {
                res.push_back(vector({left, right}));
                left = (*it)[0];
                right = (*it)[1];
            }

        }

        res.push_back(vector({left, right}));

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

    vector<vector<int>> intervals = {{2,3},{2,2},{3,3},{1,3},{5,7},{2,2},{4,6}};

    vector<vector<int>> ans = Solution().merge(intervals);

    cout << ans.size() << endl;

    return 0;
}
