package other;

import java.util.HashMap;

public class TwoSum {
	class Solution {
	    public int[] twoSum(int[] nums, int target) {
	        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	        
	        for (int i = 0; i < nums.length; i++) {
	            // 思路： 我们的map里存的数字是当前我们看的数字和target之间的差
	            // 这样设计的目的就是，下次我们只需要一直找当前map里是否有这个我们再看的数字
	            // 比如，我们之前遇到过2，那我们存7
	            // 那么下次遇到7的时候我们就可以直接get 7，把之前的index和现在的index放一起
	            // 这个就是我们的答案
	            if (map.containsKey(nums[i])) {
	                int[] ans = {map.get(nums[i]), i};
	                return ans;
	            } else {
	                map.put(target - nums[i], i);
	            }
	        }
	        return new int[0];
	    }
	}
}
