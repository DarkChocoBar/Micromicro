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
	            
	            // �ҵ���һֱ�����������0�Ļ���ֱ������
	            if (seats[i] == 0) {
	                continue;
	            }
	            
	            if (seats[i] == 1) {
	            	// edge case:  ���һ��ʼ����ߵ�arrayԪ�ز���1�Ļ����Ǿ��ҵ���һ��1��Ȼ����������� i - left
	                if (left == -1) {
	                    dist = (int)(i  - 1 - left);
	                    left = i; 
	                } else {
	                	// ƽʱ����i - left�ľ������2���Ǿ������ǵĴ�
	                    dist = Math.max(dist, (int)(i - left)/2);
	                    left = i;                  
	                }

	            }
	        } 
	        // edge case�� ��������һ��ending 0�Ļ���Ҳ�����������
	            dist = Math.max(dist, seats.length -1 - left);
	        return dist;
	    }
	}
}
