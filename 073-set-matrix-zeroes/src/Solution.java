import java.util.HashSet;
import java.util.Set;

public class Solution {

    public void setZeroes(int[][] matrix) {
        if(matrix.length == 0) {
            return;
        }
        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();
        for(int i = 0; i < matrix.length; i += 1) {
            for(int j = 0; j < matrix[0].length; j += 1) {
                if(matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        for(int i = 0; i < matrix.length; i += 1) {
            if(rows.contains(i)) {
                for(int j = 0; j < matrix[0].length; j += 1) {
                    matrix[i][j] = 0;
                }
            }
        }
        for(int j = 0; j < matrix[0].length; j += 1) {
            if(cols.contains(j)) {
                for(int i = 0; i < matrix.length; i += 1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

}
