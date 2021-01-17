#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {

    vector<int> prices = {1,3};
    int k = 0;

    if (k <= 0) {
        return 0;
    }

    // base case
    vector<int> t_i_k_0(k, 0);
    vector<int> t_i_k_1(k, INT_MIN); // T[-1][1][1]

    // recurrence
    for (int price : prices) {
        vector<int> t_i_k_0_temp(t_i_k_0);
        // T[i][0][0] = max(T[i-1][0][0], T[i-1][0][1] + prices[i])
        t_i_k_0[0] = max(t_i_k_0_temp[0], t_i_k_1[0] + price);
        // T[i][0][1] = max(T[i-1][0][1], -prices[i])
        t_i_k_1[0] = max(t_i_k_1[0], -price);
        for (int i = 1; i < k; i++) {
            // T[i][k][0] = max(T[i-1][k][0], T[i-1][k][1] + prices[i])
            t_i_k_0[i] = max(t_i_k_0_temp[i], t_i_k_1[i] + price);
            // T[i][k][1] = max(T[i-1][k][1], T[i-1][k-1][0] - prices[i])
            t_i_k_1[i] = max(t_i_k_1[i], t_i_k_0_temp[i - 1] - price);
        }
    }

    cout << *max_element(t_i_k_0.begin(), t_i_k_0.end()) << endl;

    return 0;
}
