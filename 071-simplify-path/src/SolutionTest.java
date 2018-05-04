import org.junit.Test;

public class SolutionTest {

    @Test
    public void simplifyPathTest() {
        String path = "/a/./b/../../c/";

        String ret = new Solution().simplifyPath(path);

        String out = (ret);

        System.out.println(out);

        path = "/";
        ret = new Solution().simplifyPath(path);
        out = (ret);
        System.out.println(out);

        path = "/abc/...";
        ret = new Solution().simplifyPath(path);
        out = (ret);
        System.out.println(out);

    }

}
