public class Solution {

    public static boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            char ci = s.charAt(i);
            char cj = s.charAt(j);
            if(!((ci >= 'a' && ci <= 'z') || (ci >= '0' && ci <= '9'))) {
                i++;
                continue;
            }
            if(!((cj >= 'a' && cj <= 'z') || (cj >= '0' && cj <= '9'))) {
                j--;
                continue;
            }
            if(ci != cj) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

}
