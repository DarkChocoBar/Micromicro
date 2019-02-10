package other;

public class TrappingRainWater {
	class Solution {
	    public int trap(int[] height) {
	        // 两个pointer去记录左边和右边的最大height。
	        // 当左边比右边小的时候，水的最高位置肯定小于或等于左边高度
	        // 当右边比左边小的时候，我们需要分开判断，从右边开始看起， 重新去找比当前左边高度大的值
	    	// 在找到右边更高的高度前，水的最高位置肯定小于或等于暂时知道的右边最高高度
	    	
	    	
	        int left = 0;
	        int right = height.length - 1;
	        int leftm = 0;
	        int rightm = 0;
	        int ans = 0;
	        while (left < right) {
	            leftm = Math.max(leftm, height[left]);
	            rightm = Math.max(rightm, height[right]);
	            if (leftm < rightm) {
	                ans += leftm - height[left];
	                left++;
	            } else {
	                ans += rightm - height[right];
	                right--;
	            }
	        }
	        return ans;
	    }
	}
}
