public class Solution {

    public static int strStr(String haystack, String needle) {
        if(needle.length() == 0) {
            return 0;
        }
        char[] act = new char[needle.length()];
        for(int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            if(haystack.charAt(i) == needle.charAt(0)) {
                haystack.getChars(i, needle.length() + i, act, 0);
                String strAct = new String(act);
                if(strAct.equals(needle)) {
                    return i;
                }
            }
        }
        return -1;
    }

}
