#include <iostream>
#include <vector>

using namespace std;

int main() {

    vector<int> prices;
    prices.push_back(7);
    prices.push_back(1);
    prices.push_back(5);
    prices.push_back(3);
    prices.push_back(6);
    prices.push_back(4);

    // base case
    int t_i_1_0 = 0; // T[-1][1][0]
    int t_i_1_1 = INT_MIN; // T[-1][1][1]

    // recurrence
    for (int price : prices) {
        // T[i][1][0] = max(T[i-1][1][0], T[i-1][1][1] + prices[i])
        t_i_1_0 = max(t_i_1_0, t_i_1_1 + price);
        // T[i][1][1] = max(T[i-1][1][1], -prices[i])
        t_i_1_1 = max(t_i_1_1, -price);
    }

    cout << t_i_1_0 << endl;

    return 0;
}
