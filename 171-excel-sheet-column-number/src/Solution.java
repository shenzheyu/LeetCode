public class Solution {
    public static int titleToNumber(String s) {
        int res = 0;
        for(int i = 0; i < s.length(); i++) {
            res *= 26;
            res += s.charAt(i) - 'A' + 1;
        }
        return res;
    }
}
