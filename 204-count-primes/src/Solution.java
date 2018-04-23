public class Solution {

    public static int countPrimes(int n) {
        int res = 0;
        boolean[] notPrime = new boolean[n];
        for(int i = 2; i < n; i++) {
            if (notPrime[i] == false){
                res++;
                for(int j = 2; i * j < n; j++) {
                    notPrime[i * j] = true;
                }
            }
        }
        return res;
    }

}
