#include <iostream>
#include <vector>

using namespace std;

int main() {

    vector<int> prices = {3,3,5,0,0,3,1,4};

    // base case
    int t_i_1_0 = 0;    // T[-1][1][0] = 0
    int t_i_1_1 = INT_MIN;    // T[-1][1][1] = -Infinity
    int t_i_2_0 = 0;    // T[-1][2][0] = 0
    int t_i_2_1 = INT_MIN;    // T[-1][2][1] = -Infinity

    // recurrence
    for (auto price : prices) {
        int t_i_1_0_temp = t_i_1_0;
        // T[i][1][0] = max(T[i-1][1][0], T[i-1][1][1] + price[i])
        t_i_1_0 = max(t_i_1_0_temp, t_i_1_1 + price);
        // T[i][1][1] = max(T[i-1][1][1], -price[i])
        t_i_1_1 = max(t_i_1_1, -price);
        // T[i][2][0] = max(T[i-1][2][0], T[i-1][2][1] + price[i])
        t_i_2_0 = max(t_i_2_0, t_i_2_1 + price);
        // T[i][2][0] = max(T[i-1][2][0], T[i-1][1][0] - price[i])
        t_i_2_1 = max(t_i_2_1, t_i_1_0_temp - price);
    }

    cout << max(t_i_1_0, t_i_2_0) << endl;

    return 0;
}
