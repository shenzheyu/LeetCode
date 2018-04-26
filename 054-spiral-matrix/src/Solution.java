import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if(matrix.length == 0) {
            return res;
        }
        int n = matrix.length;
        int m = matrix[0].length;
        int[] nDir = new int[]{0, 1, 0, -1};
        int[] mDir = new int[]{1, 0, -1, 0};
        boolean[][] hasAchieved = new boolean[n][m];
        int x = 0;
        int y = 0;
        int d = 0;
        for(int i = 0; i < n * m; i++) {
            res.add(matrix[x][y]);
            hasAchieved[x][y] = true;
            int dx = x + nDir[d];
            int dy = y + mDir[d];
            if(dx >= 0 && dx < n && dy >= 0 && dy < m && !hasAchieved[dx][dy]) {
                x = dx;
                y = dy;
            }else {
                d = (d + 1) % 4;
                x = x + nDir[d];
                y = y + mDir[d];
            }
        }
        return res;
    }

}
