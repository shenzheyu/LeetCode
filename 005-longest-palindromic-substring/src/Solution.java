public class Solution {

    public static String initial(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append('$');
        for(int i = 0; i < s.length(); i++) {
            sb.append('#');
            sb.append(s.charAt(i));
        }
        sb.append('#');
        sb.append('\0');
        return sb.toString();
    }

    public static String longestPalindrome(String s) {
        if(s.length() <= 1) {
            return s;
        }
        String str = initial(s);
        int n = str.length();
        int[] p = new int[n];
        int max_len = -1;
        int max_i = -1;

        int mx = 0;
        int id = 0;

        for(int i = 1; i < n; i++) {
            if(i < mx) {
                p[i] = Math.min(p[2 * id - i], mx - i);
            }else {
                p[i] = 1;
            }
            while(i + p[i] <= n - 1 && str.charAt(i - p[i]) == str.charAt(i + p[i])) {
                p[i] += 1;
            }
            if(mx < i + p[i]) {
                id = i;
                mx = i + p[i];
            }
            if(max_len < p[i] - 1) {
                max_len = p[i] - 1;
                max_i = i;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = max_i - max_len; i <= max_i + max_len; i++) {
            if(str.charAt(i) != '#') {
                sb.append(str.charAt(i));
            }
        }

        return sb.toString();
    }
}
