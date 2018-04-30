public class Solution {

    public static int myAtoi(String str) {
        if(str.length() == 0) {
            return 0;
        }
        int res = 0;
        boolean isPositive = true;
        boolean isNumber = false;
        boolean outOfRange = false;
        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(isNumber) {
                if(c >= '0' && c <= '9'){
                    if(isPositive && res > (Integer.MAX_VALUE - c + '0') / 10) {
                        res = Integer.MAX_VALUE;
                        outOfRange = true;
                        break;
                    }
                    if(!isPositive && -1 * res < (Integer.MIN_VALUE + c - '0') / 10) {
                        res = Integer.MIN_VALUE;
                        outOfRange = true;
                        break;
                    }
                    res = res * 10 + c - '0';
                } else {
                    break;
                }
            }else {
                if(c == ' ') {
                    continue;
                }
                if(c == '+') {
                    isNumber = true;
                    continue;
                }
                if(c == '-') {
                    isNumber = true;
                    isPositive = false;
                    continue;
                }
                if(c >= '0' && c <= '9') {
                    isNumber = true;
                    res = c - '0';
                    continue;
                }
                break;
            }
        }
        if(outOfRange) {
            return res;
        }
        if(isPositive) {
            return res;
        }
        return -1 * res;
    }

}
