package other;

public class TrappingRainWater {
	class Solution {
	    public int trap(int[] height) {
	        // ����pointerȥ��¼��ߺ��ұߵ����height��
	        // ����߱��ұ�С��ʱ��ˮ�����λ�ÿ϶�С�ڻ������߸߶�
	        // ���ұ߱����С��ʱ��������Ҫ�ֿ��жϣ����ұ߿�ʼ���� ����ȥ�ұȵ�ǰ��߸߶ȴ��ֵ
	    	// ���ҵ��ұ߸��ߵĸ߶�ǰ��ˮ�����λ�ÿ϶�С�ڻ������ʱ֪�����ұ���߸߶�
	    	
	    	
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
