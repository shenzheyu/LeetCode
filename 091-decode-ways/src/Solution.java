public class Solution {

    public int numDecodings(String s) {
        if(s.length() == 0) {
            return 0;
        }
        int[] numD = new int[s.length()];
        if(s.charAt(0) - '0' == 0) {
            numD[0] = 0;
        }else {
            numD[0] = 1;
        }
        if(s.length() == 1) {
            return numD[0];
        }
        if(s.charAt(0) - '0' == 1 && s.charAt(1) - '0' > 0) {
            numD[1] = numD[0] + 1;
        }else if(s.charAt(0) - '0' == 2 && s.charAt(1) - '0' <= 6 && s.charAt(1) - '0' > 0) {
            numD[1] = numD[0] + 1;
        }else if(s.charAt(1) - '0' == 0 && (s.charAt(0) - '0' == 1 || s.charAt(0) - '0' == 2)){
            numD[1] = numD[0];
        }else if(s.charAt(1) - '0' > 0){
            numD[1] = numD[0];
        }else {
            numD[1] = 0;
        }
        for(int i = 2; i < s.length(); i += 1) {
            if(s.charAt(i - 1) - '0' == 1 && s.charAt(i) - '0' > 0) {
                numD[i] = numD[i - 1] + numD[i - 2];
            }else if(s.charAt(i - 1) - '0' == 2 && s.charAt(i) - '0' <= 6 && s.charAt(i) - '0' > 0) {
                numD[i] = numD[i - 1] + numD[i - 2];
            }else if(s.charAt(i) - '0' == 0 &&(s.charAt(i - 1) - '0' == 1 || s.charAt(i - 1) - '0' == 2)) {
                numD[i] = numD[i - 2];
            }else if(s.charAt(i) - '0' > 0) {
                numD[i] = numD[i - 1];
            }
            else {
                numD[i] = 0;
            }
        }
        return numD[s.length() - 1];
    }

}
