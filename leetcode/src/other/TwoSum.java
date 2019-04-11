package other;

import java.util.HashMap;

public class TwoSum {
	class Solution {
	    public int[] twoSum(int[] nums, int target) {
	        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	        
	        for (int i = 0; i < nums.length; i++) {
	            // ˼·�� ���ǵ�map���������ǵ�ǰ���ǿ������ֺ�target֮��Ĳ�
	            // ������Ƶ�Ŀ�ľ��ǣ��´�����ֻ��Ҫһֱ�ҵ�ǰmap���Ƿ�����������ٿ�������
	            // ���磬����֮ǰ������2�������Ǵ�7
	            // ��ô�´�����7��ʱ�����ǾͿ���ֱ��get 7����֮ǰ��index�����ڵ�index��һ��
	            // ����������ǵĴ�
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
