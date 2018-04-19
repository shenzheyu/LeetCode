public class Solution {
    public static String convertToTitle(int n) {
        String str = "";
        while (n > 0) {
            int t = n % 26;
            if (t == 0) {
                str += 'Z';
                n--;
            } else {
                str += (char)('A' + t - 1);
            }
            n /= 26;
        }
        String res = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            res += str.charAt(i);
        }
        return res;
    }
}