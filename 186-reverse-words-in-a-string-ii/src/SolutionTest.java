import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void reverseWordsTest() {
        char[] str = new char[]{'t','h','e',' ','s','k','y',' ','i','s',' ','b','l','u','e'};
        char[] exp = new char[]{'b','l','u','e',' ','i','s',' ','s','k','y',' ','t','h','e'};
        Solution.reverseWords(str);
        for(int i = 0; i < str.length; i++){
            Assert.assertEquals(exp[i], str[i]);
        }
    }

}
