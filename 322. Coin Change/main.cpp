#include <iostream>
#include <vector>

using namespace std;

int main() {

    vector<int> coins;
    coins.push_back(1);
    coins.push_back(2);
    coins.push_back(5);

    int amount = 3;

    vector<int> dp(amount + 1, INT_MAX);

    // d[0] - 0
    dp[0] = 0;

    // dp[i] = min(dp[i - coin] + 1 | coin \in coins), i > 0
    for (int i = 1; i <= amount; i++) {
        for (int coin : coins) {
            if (i - coin < 0 || dp[i - coin] == -1) {
                continue;
            }
            dp[i] = min(dp[i], dp[i - coin] + 1);
        }
        if (dp[i] == INT_MAX) {
            dp[i] = -1;
        }
    }

    cout << dp[amount] << endl;

    return 0;
}
