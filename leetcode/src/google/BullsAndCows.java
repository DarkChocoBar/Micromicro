package google;

import java.util.HashMap;

public class BullsAndCows {
    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        int[] freq = new int[10];
        
        for (int i = 0; i < secret.length(); i++) {
            char c1 = secret.charAt(i);
            char c2 = guess.charAt(i);
            if (c1 != c2) {
               // if the number from guess was previously seen in secret
                if (freq[c2 - '0'] > 0) {
                    cows++;
                }
                
                // if the number from secret was previously seen in guess
                if (freq[c1 - '0'] < 0) {
                    cows++;
                }
                
                // update frequency of each number
                // if seen in secret, increase
                // if seen in guess, decrease
                freq[c1 - '0']++;
                freq[c2 - '0']--;
            } else {
                bulls++;
            }
        }
        
        return bulls + "A" + cows + "B";
    }
	
	class Solution2 {
	    class Kevin {
	        int total;
	        int miss;
	        int found;
	        
	        public Kevin(int total, int found) {
	            this.total = total;
	            this.found = found;
	            this.miss = 0;
	            
	        }
	    }
	    
	    public String getHint(String secret, String guess) {
	        char[] ca1 = secret.toCharArray();
	        HashMap<Character, Integer> map = new HashMap<>();
	        for (int i = 0; i < ca1.length; i++) {
	            char c = ca1[i];
	            if (!map.containsKey(c)) {
	                map.put(c, 1);
	            } else {
	                map.put(c, map.get(c) + 1);
	            }
	        }
	        int found = 0;
	        int miss = 0;
	        HashMap<Character, Integer> map1 = new HashMap<>();
	        char[] ca2 = guess.toCharArray();
	        for (int i = 0; i < ca2.length; i++) {
	            char c = ca2[i];
	            if (!map1.containsKey(c)) {
	                map1.put(c, 1);
	            } else {
	                map1.put(c, map1.get(c) + 1);
	            }
	        }
	        
	        // "1122"      -> "3A0B"
	        // "1222"
	        for (int i = 0; i < ca1.length; i++) {
	            char c1 = ca1[i];
	            char c2 = ca2[i];
	            if (c1 != c2) {
	                continue;
	            } else {
	                map.put(c1, map.get(c1) - 1);
	                map1.put(c2, map1.get(c2) - 1);
	                found++;
	            }
	        }
	        
	        for (int i = 0; i < ca1.length; i++) {
	            char c1 = ca1[i];
	            char c2 = ca2[i];
	            if (c1 != c2) {
	                
	                if (map.getOrDefault(c2, 0) == 0) {
	                    continue;
	                } else {
	                    miss++;
	                    //map1.put(c2, map1.get(c2) - 1);  
	                    map.put(c2, map.get(c2) - 1); 
	                }                             
	                
	            } else {
	                continue;
	            }
	        }
	        
	        StringBuilder sb = new StringBuilder();
	        sb.append(found);
	        sb.append("A");
	        sb.append(miss);
	        sb.append("B");
	        
	        return sb.toString();
	    }
	}
}
