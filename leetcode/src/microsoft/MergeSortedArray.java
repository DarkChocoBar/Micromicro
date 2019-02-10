package microsoft;

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
}
