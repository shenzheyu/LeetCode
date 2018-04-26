public class TicTacToe {
    private int[][] rows;
    private int[][] cols;
    private int[] diag = new int[3];
    private int[] adiag = new int[3];
    private int n;

    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        this.n = n;
        rows = new int[3][n];
        cols = new int[3][n];
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < n; j++){
                rows[i][j] = 0;
                cols[i][j] = 0;
            }
            diag[i] = 0;
            adiag[i] = 0;
        }
    }

    /** Player {player} makes a move at ({row}, {col}).
     @param row The row of the board.
     @param col The column of the board.
     @param player The player, can be either 1 or 2.
     @return The current winning condition, can be either:
     0: No one wins.
     1: Player 1 wins.
     2: Player 2 wins. */
    public int move(int row, int col, int player) {
        if(row == col) {
            diag[row] = player;
        }
        if(row + col == 2) {
            adiag[row] = player;
        }
        rows[row][col] = player;
        cols[col][row] = player;
        boolean win1 = true;
        boolean win2 = true;
        boolean win3 = true;
        boolean win4 = true;
        for(int i = 0; i < 3; i++) {
            if(rows[row][i] != player) {
                win1 = false;
            }
            if(cols[col][i] != player) {
                win2 = false;
            }
            if(diag[i] != player) {
                win3 = false;
            }
            if(adiag[i] != player) {
                win4 = false;
            }
        }
        if(win1 || win2 || win3 || win4) {
            return player;
        }
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
