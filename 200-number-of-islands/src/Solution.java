public class Solution {

    public static int numIslands(char[][] grid) {
        if(grid.length == 0) {
            return 0;
        }
        int res = 0;
        int R = grid.length;
        int C = grid[0].length;
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if(grid[i][j] == '1') {
                    mark(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    public static void mark(char[][] grid, int i, int j) {
        int R = grid.length;
        int C = grid[0].length;
        if(i < 0 || i >= R || j < 0 || j >= C || grid[i][j] != '1') {
            return;
        }
        grid[i][j] = '0';
        mark(grid, i - 1, j);
        mark(grid, i + 1, j);
        mark(grid, i, j + 1);
        mark(grid, i, j - 1);
    }

}
