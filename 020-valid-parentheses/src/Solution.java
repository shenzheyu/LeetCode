import java.util.Iterator;
import java.util.Stack;

public class Solution {

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack.push(s.charAt(i));
            }
            if(s.charAt(i) == ')' && (stack.isEmpty() || stack.pop() != '(')) {
                return false;
            }
            if(s.charAt(i) == ']' && (stack.isEmpty() || stack.pop() != '[')) {
                return false;
            }
            if(s.charAt(i) == '}' && (stack.isEmpty() || stack.pop() != '{')) {
                return false;
            }
        }
        if(!stack.isEmpty()) {
            return false;
        }
        return true;
    }

}
