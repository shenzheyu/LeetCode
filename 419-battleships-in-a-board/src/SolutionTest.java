import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void countBattleships() {
        char[][] board = new char[4][];
        board[0] = new char[]{'X', '.', '.', 'X'};
        board[1] = new char[]{'.', '.', '.', 'X'};
        board[2] = new char[]{'.', '.', '.', 'X'};
        board[3] = new char[]{'.', '.', '.', 'X'};
        Assert.assertEquals(2, Solution.countBattleships(board));
    }

}
