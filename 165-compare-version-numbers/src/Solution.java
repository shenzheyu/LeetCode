public class Solution {

    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int ret = 0;
        int v1l = v1.length;
        int v2l = v2.length;
        int i = 0;
        while(i < v1l || i < v2l) {
            int v1i;
            int v2i;
            if(i < v1l) {
                v1i = Integer.parseInt(v1[i]);
            }else {
                v1i = 0;
            }
            if(i < v2l) {
                v2i = Integer.parseInt(v2[i]);
            }else {
                v2i = 0;
            }
            if(v1i > v2i) {
                ret = 1;
                break;
            }else if(v1i < v2i) {
                ret = -1;
                break;
            }
            i += 1;
        }
        return ret;
    }

}
