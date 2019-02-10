package google;

public class MaximizeDistanceToClosetPassenger {
	class Solution {
	    public int maxDistToClosest(int[] seats) {
	        if (seats.length <= 1) {
	            return 0;
	        }
	        int left = -1;
	        int dist = 0;
	        for (int i = 0; i < seats.length; i++) {            
	            
	            // 找到后，一直遍历，如果是0的话，直接跳过
	            if (seats[i] == 0) {
	                continue;
	            }
	            
	            if (seats[i] == 1) {
	            	// edge case:  如果一开始最左边的array元素不是1的话，那就找到第一个1，然后最大距离就是 i - left
	                if (left == -1) {
	                    dist = (int)(i  - 1 - left);
	                    left = i; 
	                } else {
	                	// 平时就是i - left的距离除以2，那就是我们的答案
	                    dist = Math.max(dist, (int)(i - left)/2);
	                    left = i;                  
	                }

	            }
	        } 
	        // edge case： 如果最后还有一堆ending 0的话，也可以坐在最后
	            dist = Math.max(dist, seats.length -1 - left);
	        return dist;
	    }
	}
}
