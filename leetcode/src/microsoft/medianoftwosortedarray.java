package microsoft;

public class medianoftwosortedarray {
	class Solution {
	    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
	        int l1 = nums1.length;
	        int l2 = nums2.length;
	        if (l1 > l2) {
	            return findMedianSortedArrays(nums2, nums1);
	        }
	        
	        // 思路：我们只操作长度较小的array
	        // 这样我们的binary search时间相对来说更小
	        
	        // 长度要记录下来
	        int len = l1 + l2;
	        
	        // binary search： 这里要记录左边的pointer和右边的pointer
	        int cutL = 0;
	        int cutR = l1;
	        
	        // 对第一个数组的分割点
	        int cut1 = cutR / 2;
	        
	        // 对第二个数组的分割点
	        // 用公式可以确定: 1 | 2 3 /  4 | 5为例子，cut1 就是1, 那么cut2就是 2 - 1 = 1
	        int cut2 = len / 2 - cut1;
	        
	        
	        while (cut1 <= l1) {
	            
	            // binary search每次要更形cut1的位置
	            cut1 = (cutR - cutL) / 2 + cutL;
	            
	            // cut2因为cut1变了，为了保证左边数量的相同，必须也要变
	            // 左边的和永远不会超过 len / 2
	            // 奇数数组和的情况下就会是len /2 - 1， 偶数的话肯定是len /2
	            cut2 = len / 2 - cut1;
	            
	            // 记录当前分割点左右的数字是什么
	            
	            // 左边的l1 就是nums1 中cut1 - 1位置上的数字，以此类推
	            // 如果cut1 == 0， 那意思是nums1没有办法分割，分割点在最左边，左边没有数字
	            // 那我们就故意将他设置成最小的，这样之后可以躲过case 1
	            // 说明我们不用切
	            
	            // 这里的想法其实是这样
	            // 假设我们nums1的分割点在最右边，那说明之前肯定是分割点一直在往右走
	            // 那如果已经到了最右边的话，我们久可以安心的把R1 设置成恩一个很大的数字， 这样即使后头的检查过了，分割正确，我们也知道应该用另一个R来作为答案
	            // 说明我们不用挪
	            double L1 = (cut1 == 0) ? Integer.MIN_VALUE : nums1[cut1 - 1];
	            double L2 = (cut2 == 0) ? Integer.MIN_VALUE : nums2[cut2 - 1];
	            double R1 = (cut1 == l1) ? Integer.MAX_VALUE : nums1[cut1];
	            double R2 = (cut2 == l2) ? Integer.MAX_VALUE : nums2[cut2];

	            // case 1：
	            if (L1 > R2) {
	                // 说明我们的数字还是太大了，往左挪
	                cutR = cut1 - 1;
	            
	            //case 2
	            } else if (R1 < L2) {
	                // 说明我们的数字太小了，往右挪
	                cutL = cut1 + 1;
	            } else {
	                if (len % 2 == 0) {
	                    double left = (L1 > L2)? L1 : L2;
	                    double right = (R1 < R2)? R1 : R2;
	                    return (left + right) / 2;
	                } else {                    
	                    return (R1 < R2) ? R1 : R2;
	                }

	            }
	        }
	        return 0;
	    }
	}
}
