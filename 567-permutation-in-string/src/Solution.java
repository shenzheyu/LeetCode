import java.util.*;

public class Solution {

//    Time Limit Exceeded
//    public boolean checkInclusion(String s1, String s2) {
//        for(int i = 0; i < s2.length() - s1.length() + 1; i += 1) {
//            boolean[] used = new boolean[s1.length()];
//            for(int j = 0; j < s1.length(); j += 1) {
//                for(int k = 0; k < s1.length(); k += 1) {
//                    if(s2.charAt(i + j) == s1.charAt(k) && !used[k]) {
//                        used[k] = true;
//                        break;
//                    }
//                }
//            }
//            boolean isInclusion = true;
//            for(int j = 0; j < s1.length(); j += 1) {
//                if(!used[j]) {
//                    isInclusion = false;
//                    break;
//                }
//            }
//            if(isInclusion) {
//                return true;
//            }
//        }
//        return false;
//    }

    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> map1 = new HashMap<>();
        for(int i = 0; i < s1.length(); i += 1) {
            if(!map1.containsKey(s1.charAt(i))) {
                map1.put(s1.charAt(i), 1);
            }else {
                map1.put(s1.charAt(i), map1.get(s1.charAt(i)) + 1);
            }
        }
        for(int i = 0; i < s2.length(); i += 1) {
            if(!map1.containsKey(s2.charAt(i))) {
                map1.put(s2.charAt(i), -1);
            }else {
                map1.put(s2.charAt(i), map1.get(s2.charAt(i)) - 1);
            }
            if(i - s1.length() >= 0) {
                map1.put(s2.charAt(i - s1.length()), map1.get(s2.charAt(i - s1.length())) + 1);
            }
            if(isAllZero(map1)) {
                return true;
            }
        }
        return false;
    }

    public boolean isAllZero(Map<Character, Integer> map) {
        List<Integer> list = new ArrayList<>(map.values());
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            if(iterator.next() != 0) {
                return false;
            }
        }
        return true;
    }

}
