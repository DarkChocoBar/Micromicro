package google;

import java.util.HashMap;

public class longestSubstrWith2 {
	class Solution {
	    public int lengthOfLongestSubstringTwoDistinct(String s) {
	        HashMap<Character, Integer> frequency = new HashMap<>();
	        int start = 0;
	        int end = 0;
	        int count = 0;
	        int ans = 0;
	        
	        while (end < s.length()) {
	            char ch = s.charAt(end);
	            // 如果见过，那就简单的增加长度
	            if (frequency.containsKey(ch)) {
	                frequency.put(ch, frequency.getOrDefault(ch, 0) + 1);
	                end++;
	                
	                // 如果没见过，那就根据count的情况来看
	                // 如果count仍然小于二，那就简单的加长度并update
	            } else {
	                if (count < 2) {
	                    frequency.put(ch, frequency.getOrDefault(ch, 0) + 1);
	                    count++;
	                    end++;
	                    
	                    // 如果count已经大于等于2了，那要在hashmap中删除掉之前一个字母
	                } else {
	                    while (count >= 2) {
	                        char left = s.charAt(start);
	                        frequency.put(left, frequency.get(left) - 1);
	                        if (frequency.get(left) == 0) {
	                            frequency.remove(left);
	                            count--;
	                        }
	                        start++;
	                    }
	                }
	            }
	            //System.out.println("end: " + end + ", start: " + start);
	            ans = Math.max(ans, end - start);
	        }        
	        return ans;
	    }
	}
	
	public class Solution2 {
	    public int lengthOfLongestSubstringTwoDistinct(String s) {
	        HashMap<Character,Integer> map = new HashMap<>();
	        int start = 0, end = 0, counter = 0, len = 0;
	        while(end < s.length()){
	            char c = s.charAt(end);
	            map.put(c, map.getOrDefault(c, 0) + 1);
	            if(map.get(c) == 1) counter++;//new char
	            end++;
	            while(counter > 2){
	                char cTemp = s.charAt(start);
	                map.put(cTemp, map.get(cTemp) - 1);
	                if(map.get(cTemp) == 0){
	                    counter--;
	                }
	                start++;
	            }
	            len = Math.max(len, end-start);
	        }
	        return len;
	    }
	}
	
	class Solution3 {
		public int lengthOfLongestSubstringTwoDistinct(String s) {
		    if (s.isEmpty()) return 0;
		    int max = 1;
		    int p1 = 0, p2 = 0;
		    int last = 1;
		    char[] chars = s.toCharArray();
		    for (int i = 1; i < chars.length; i++) {
		        if (p1 != p2 && chars[i] != chars[p1] && chars[i] != chars[p2]) {
		            if (last > max) max = last;
		            
		            last = i - p1;
		            p1 = p2;
		            p2 = i;
		        } else {
		            if (chars[i] == chars[p1]) {
		                p1 = p1 == p2 ? i : p2;
		            }
		            last++;
		            p2 = i;
		        }
		    }
		    
		    if (last > max) max = last;
		    return max;
		}
	}
}
