public class Solution {

    public static int countBattleships(char[][] board) {
        int res = 0;
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                if(board[i][j] == 'X') {
                    if(i == 0 && j == 0) {
                        res += 1;
                    }else if(i != 0 && j == 0){
                        if(board[i - 1][j] == '.') {
                            res += 1;
                        }
                    }else if(i == 0 && j != 0) {
                        if(board[i][j - 1] == '.') {
                            res += 1;
                        }
                    }else {
                        if(board[i][j - 1] == '.' && board[i - 1][j] == '.') {
                            res += 1;
                        }
                    }
                }
            }
        }
        return res;
    }

}
