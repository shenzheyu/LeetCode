public class Solution {

    public static int compress(char[] chars) {
        int ptr = 1;
        char c = chars[0];
        int nums = 1;
        for(int i = 1; i < chars.length; i++) {
            if(chars[i] == c){
                nums ++;
            }else {
                if(nums == 1) {
                    c = chars[i];
                    chars[ptr] = c;
                    ptr++;
                }else {
                    String numstr = new Integer(nums).toString();
                    for(int j = 0; j < numstr.length(); j++) {
                        chars[ptr] = numstr.charAt(j);
                        ptr++;
                    }
                    c = chars[i];
                    chars[ptr] = c;
                    nums = 1;
                    ptr++;
                }
            }
        }
        if(nums != 1) {
            String numstr = new Integer(nums).toString();
            for(int j = 0; j < numstr.length(); j++) {
                chars[ptr] = numstr.charAt(j);
                ptr++;
            }
        }
        return ptr;
    }

}
