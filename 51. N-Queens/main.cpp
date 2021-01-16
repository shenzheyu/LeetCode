#include <iostream>
#include <vector>
#include <string>

using namespace std;

vector<vector<string>> res;

bool valid(vector<string> board, string new_col) {
    int new_x = (int)new_col.find("Q");
    int new_y = (int)board.size();
    for (int y = 0; y < board.size(); y++) {
        string col = board[y];
        int x = (int)col.find("Q");
        if (new_x == x) {
            return false;
        }
        if (new_x == x + (new_y - y) || new_x == x - (new_y - y)) {
            return false;
        }
    }
    return true;
}

void back_track(int num, vector<string> board) {
    // stop check
    if (board.size() == num) {
        res.push_back(board);
        return;
    }

    // for choice in choice_list
    for (int i = 0; i < num; i++) {
        // construct choice
        string col;
        col += string(i, '.');
        col += string(1, 'Q');
        col += string(num - i - 1, '.');

        // validation check
        if (!valid(board, col)) {
            continue;
        }

        // do choice
        board.push_back(col);

        // recursive
        back_track(num, board);

        // redo choice
        board.pop_back();
    }
}

int main() {
    int num = 8;

    vector<string> board;

    back_track(num, board);

    cout << res.size() << endl;

    return 0;
}
