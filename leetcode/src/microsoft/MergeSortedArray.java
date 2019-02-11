package microsoft;

import java.util.HashMap;

// 88
public class MergeSortedArray {
	
	class Solution {
	    public void merge(int[] nums1, int m, int[] nums2, int n) {
	        int i = nums1.length - 1;
	        int p1 = m - 1;
	        int p2 = n - 1;
	        if (m == 0) {
	            System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
	            return;
	        }
	        
	
	        
	        while (p1 >= 0 && p2 >= 0) {
	            if (nums1[p1] >= nums2[p2]) {
	                nums1[i] = nums1[p1];
	                p1--;
	            } else {
	                nums1[i] = nums2[p2];
	                p2--;  
	            }
	            i--;
	        }
	
	        // 有可能nums2那边还有东西没换过来
	        
	        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
	    }
	}
	
	class Solution2 {
	    public void sortColors(int[] nums) {
	        HashMap<Integer, Integer> map = new HashMap<>();
	        for (int i = 0; i < nums.length; i++) {
	            
	            if (!map.containsKey(nums[i])) {
	                map.put(nums[i], 1);
	            } else {
	                map.put(nums[i], map.get(nums[i]) + 1);
	            }
	        }
	        int one = (!map.containsKey(1))? 0 : map.get(1);
	        int two = (!map.containsKey(2))? 0 : map.get(2);
	        int zero = (!map.containsKey(0))? 0 : map.get(0);

	        int i = 0;
	        int[] temp = new int[one + two + zero];
	        while (i < zero) {
	            temp[i++] = 0;
	        } 
	                     
	        i = 0;
	        while (i < one) {
	            temp[(i + zero)] = 1;
	            i++;
	        } 
	        i = 0;
	        while (i < two) {
	            temp[i + zero + one] = 2;
	            i++;
	        } 
	        System.arraycopy(temp, 0, nums, 0, nums.length);
	    }
	    

	}
}
