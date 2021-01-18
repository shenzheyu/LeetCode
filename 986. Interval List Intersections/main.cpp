#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

class Solution {
public:
    vector<vector<int>> intervalIntersection(vector<vector<int>>& firstList, vector<vector<int>>& secondList) {
        // sort intervals
        sort(firstList.begin(), firstList.end(), compare);
        sort(secondList.begin(), secondList.end(), compare);

        // two pointers traverse A and B
        int i = 0;
        int j = 0;

        vector<vector<int>> res;

        while (i < firstList.size() and j < secondList.size()) {
            int a1 = firstList[i][0];
            int a2 = firstList[i][1];
            int b1 = secondList[j][0];
            int b2 = secondList[j][1];

            // check whether a and b have intersection
            if (b2 >= a1 and a2 >= b1) {
                int c1 = max(a1, b1);
                int c2 = min(a2, b2);
                res.push_back(vector({c1, c2}));
            }

            // i and j depend on a2 and b2
            if (b2 < a2) {
                j++;
            } else {
                i++;
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

    vector<vector<int>> firstList = {{0,2},{5,10},{13,23},{24,25}};
    vector<vector<int>> sendondList = {{1,5},{8,12},{15,24},{25,26}};

    vector<vector<int>> ans = Solution().intervalIntersection(firstList, sendondList);

    cout << ans.size() << endl;

    return 0;
}
