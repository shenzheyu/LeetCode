import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Solution {

    public static int firstUniqChar(String s) {
        if(s.length() == 0) {
            return -1;
        }
        Map<Character,Integer> NumsMap = new HashMap<>();
        Map<Character,Integer> IndexMap = new HashMap<>();
        int index = Integer.MAX_VALUE;
        for(int i = 0; i < s.length(); i++) {
            if(NumsMap.containsKey(s.charAt(i))) {
                NumsMap.put(s.charAt(i), NumsMap.get(s.charAt(i)) + 1);
            } else {
                NumsMap.put(s.charAt(i), 1);
                IndexMap.put(s.charAt(i), i);
            }
        }
        Set keys = NumsMap.keySet();
        if(keys != null) {
            Iterator iterator = keys.iterator();
            while(iterator.hasNext()) {
                Object key = iterator.next();
                Object value = NumsMap.get(key);
                if(value.equals(1)) {
                    if(IndexMap.get(key) < index) {
                        index = IndexMap.get(key);
                    }
                }
            }
        }
        if(index != Integer.MAX_VALUE) {
            return index;
        }
        return -1;
    }

}
