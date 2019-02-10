package google;

// 777
public class SwapAdjacentLRString {
	class Solution {
	    public boolean canTransform(String start, String end) {
	        // if L and R numbers dont match, return false
	        if (!start.replace("X", "").equals(end.replace("X", ""))) {
	            return false;
	        }
	        
	        // pointer for end string to detect if character 'L' is on the left side of start 'L'
	        int pl = 0;
	        for (int i = 0; i < start.length(); i++) {
	            char c = start.charAt(i);
	            if (c == 'L') {
	                while (end.charAt(pl) != 'L') {
	                    pl++;
	                }
	                // this while loop will give us the index of the next L we are looking for
	                if (i < pl) {
	                    return false;
	                } else {
	                    pl++;
	                }
	            }
	        }
	        
	        // pointer for end string to detect if character 'L' is on the left side of start 'L'
	        int pr = 0;
	        for (int i = 0; i < start.length(); i++) {
	            char c = start.charAt(i);
	            if (c == 'R') {
	                while (end.charAt(pr) != 'R') {
	                    pr++;
	                }
	                // this while loop will give us the index of the next R we are looking for
	                if (i > pr) {
	                    return false;
	                } else {
	                    pr++;
	                }
	            }
	        }
	        
	        return true;
	    }
	}
	
	class Solution2 {
	    public boolean canTransform(String start, String end) {
	        int size = start.length();
	        char[] s= start.toCharArray();
	        char[] e = end.toCharArray();
	        
	        int sp = 0;
	        int ep = 0;
	        while (sp < size && ep < size) {
	            while (sp < size && s[sp] == 'X') {
	                sp++;
	            }
	            
	            while (ep < size && e[ep] == 'X') {
	                ep++;
	            }
	            
	            // these while loops will give me the index of next characters
	            
	            if (sp != size && ep != size) {
	                
	            } else {
	                if (sp == size && ep == size) {
	                    break;
	                } else {
	                    return false;                    
	                }

	            }

	            
	            if (s[sp] != e[ep] || (s[sp] == 'L' && sp < ep) || (s[sp] == 'R' && sp > ep)) {
	                System.out.println("testing");
	                return false;
	            }
	            
	            sp++;
	            ep++;
	        }
	        return true;
	    }
	}
}
