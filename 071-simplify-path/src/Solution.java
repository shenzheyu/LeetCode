import java.util.Iterator;
import java.util.Stack;

public class Solution {

    public String simplifyPath(String path) {
    	String[] dir = path.split("/");
    	Stack<String> stack = new Stack<>();
    	int ptr = 0;
    	for(int i = 0; i < dir.length; i += 1) {
    	    if(dir[i].equals(".") || dir[i].equals("")) {
    	        continue;
            }else if(dir[i].equals("..")) {
    	        if(!stack.isEmpty()) {
    	            stack.pop();
                }
            }else {
    	        stack.push(dir[i]);
            }
        }
    	StringBuilder sb = new StringBuilder();
        Iterator<String> iterator = stack.iterator();
    	while(iterator.hasNext()){
    	    sb.append('/');
    	    sb.append(iterator.next());
        }
        if(sb.length() == 0) {
        	sb.append('/');
        }
        return sb.toString();
    }

}
