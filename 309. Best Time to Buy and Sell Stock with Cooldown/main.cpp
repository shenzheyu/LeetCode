#include <iostream>
#include <vector>

using namespace std;

int main() {

    vector<int> prices = {1,2,3,0,2};

    // base case
    int t_i_k_0 = 0;    // T[i][k][0] = 0
    int t_i_k_1 = INT_MIN;  // T[i][k][1] = -Infinity

    int t_i_k_0_prev = 0; // T[i - 2][k][0]

    // recurrence
    for (auto price : prices) {
        int t_i_k_0_temp = t_i_k_0;
        // T[i][k][0] = max(T[i-1][k][0], T[i-1][k][1] + prices[i])
        t_i_k_0 = max(t_i_k_0_temp, t_i_k_1 + price);
        // T[i][k][1] = max(T[i-1][k][1], T[i-2][k][0] - prices[i])
        t_i_k_1 = max(t_i_k_1, t_i_k_0_prev - price);
        // T[i - 2][k][0] = T[i - 1][k][0]
        t_i_k_0_prev = t_i_k_0_temp;
    }

    cout << t_i_k_0 << endl;

    return 0;
}
