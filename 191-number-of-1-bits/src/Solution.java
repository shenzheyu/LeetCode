public class Solution {

    // you need to treat n as an unsigned value
    public static int hammingWeight(int n) {
        int res = 0;
        while(n != 0) {
            res ++;
            n &= (n - 1);
        }
        return res;
    }

}
