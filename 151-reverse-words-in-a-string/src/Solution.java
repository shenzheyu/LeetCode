public class Solution {

    public static String reverseWords(String s) {
        StringBuilder res = new StringBuilder();
        boolean extraSpace = true;
        boolean hasSpace = false;
        for(int i = s.length() - 1; i >= 0; i--) {
            if(s.charAt(i) == ' ' && extraSpace){
                continue;
            }
            if(s.charAt(i) == ' ' && !extraSpace){
                hasSpace = true;
                extraSpace = true;
            }
            if(s.charAt(i) != ' ') {
                if(hasSpace) {
                    res.append(' ');
                    hasSpace = false;
                }
                res.append(s.charAt(i));
                extraSpace = false;
            }
        }
        int start = 0;
        for(int i = 0; i < res.length(); i++) {
            if(res.charAt(i) == ' ') {
                reverseWord(res, start, i - 1);
                start = i + 1;
            }
        }
        reverseWord(res, start, res.length() - 1);
        return res.toString();
    }

    public static void reverseWord(StringBuilder s, int start, int end) {
        while(start < end) {
            char temp = s.charAt(start);
            s.setCharAt(start, s.charAt(end));
            s.setCharAt(end, temp);
            start += 1;
            end -= 1;
        }
    }

}
