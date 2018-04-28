import org.junit.Test;

public class SolutionTest {

    @Test
    public void rotateTest() {
        int[][] matrix = new int[4][];
        matrix[0] = new int[]{1,2,3,4};
        matrix[1] = new int[]{5,6,7,8};
        matrix[2] = new int[]{9,10,11,12};
        matrix[3] = new int[]{13,14,15,16};
        Solution.rotate(matrix);
    }

}
