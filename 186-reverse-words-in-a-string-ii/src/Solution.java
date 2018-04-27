import java.util.Stack;

public class Solution {

    public static void reverseWord(char[] s, int start, int end) {
        char temp;
        while(start < end) {
            temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }

    public static void reverseWords(char[] s) {
        int from = 0;
        int to = 0;
        int start = 0;
        int end = s.length - 1;
        char temp;
        reverseWord(s, start, end);
        for(int i = start; i <= end; i++) {
            if(s[i] == ' ') {
                to = i - 1;
                reverseWord(s, from, to);
                from = i + 1;
            }
        }
        reverseWord(s, from, end);
    }

}
