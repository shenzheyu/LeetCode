import org.junit.Assert;
import org.junit.Test;

public class TicTacToeTest {

    @Test
    public void moveTest() {
        TicTacToe toe = new TicTacToe(3);
        Assert.assertEquals(0, toe.move(0, 0, 1));
        Assert.assertEquals(0, toe.move(0, 2, 2));
        Assert.assertEquals(0, toe.move(2, 2, 1));
        Assert.assertEquals(0, toe.move(1, 1, 2));
        Assert.assertEquals(0, toe.move(2, 0, 1));
        Assert.assertEquals(0, toe.move(1, 0, 2));
        Assert.assertEquals(1, toe.move(2, 1, 1));
    }

}
