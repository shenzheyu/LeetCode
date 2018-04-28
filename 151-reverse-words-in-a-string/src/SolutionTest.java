import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void reverseWords() {
        String str = "  the sky is  blue  ";
        String exp = "blue is sky the";
        String act = Solution.reverseWords(str);
        Assert.assertTrue(act.equals(exp));
    }

}
