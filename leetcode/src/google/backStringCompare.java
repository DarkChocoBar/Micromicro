package google;

public class backStringCompare {
	// follow up, O(n) time and O(1) space
	class Solution {
	    public boolean backspaceCompare(String S, String T) {
	        int count = 0;
	        String s1 = "";
	        for (int i = S.length() - 1; i >= 0; i--) {
	            char c = S.charAt(i);
	            if (c == '#') {
	                count++;
	            } else {
	                if (count > 0) {
	                    count--;
	                    continue;
	                } else{
	                    s1 += c;
	                }
	            }
	        }
	        
	        count = 0;
	        String s2 = "";
	        for (int i = T.length() - 1; i >= 0; i--) {
	            char c = T.charAt(i);
	            if (c == '#') {
	                count++;
	            } else {
	                if (count > 0) {
	                    count--;
	                    continue;
	                } else{
	                    s2 += c;
	                }
	            }
	        }
	        return s1.equals(s2);
	    }
	}
}
