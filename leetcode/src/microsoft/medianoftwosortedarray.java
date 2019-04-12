package microsoft;

public class medianoftwosortedarray {
	class Solution {
	    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
	        int l1 = nums1.length;
	        int l2 = nums2.length;
	        if (l1 > l2) {
	            return findMedianSortedArrays(nums2, nums1);
	        }
	        
	        // ˼·������ֻ�������Ƚ�С��array
	        // �������ǵ�binary searchʱ�������˵��С
	        
	        // ����Ҫ��¼����
	        int len = l1 + l2;
	        
	        // binary search�� ����Ҫ��¼��ߵ�pointer���ұߵ�pointer
	        int cutL = 0;
	        int cutR = l1;
	        
	        // �Ե�һ������ķָ��
	        int cut1 = cutR / 2;
	        
	        // �Եڶ�������ķָ��
	        // �ù�ʽ����ȷ��: 1 | 2 3 /  4 | 5Ϊ���ӣ�cut1 ����1, ��ôcut2���� 2 - 1 = 1
	        int cut2 = len / 2 - cut1;
	        
	        
	        while (cut1 <= l1) {
	            
	            // binary searchÿ��Ҫ����cut1��λ��
	            cut1 = (cutR - cutL) / 2 + cutL;
	            
	            // cut2��Ϊcut1���ˣ�Ϊ�˱�֤�����������ͬ������ҲҪ��
	            // ��ߵĺ���Զ���ᳬ�� len / 2
	            // ��������͵�����¾ͻ���len /2 - 1�� ż���Ļ��϶���len /2
	            cut2 = len / 2 - cut1;
	            
	            // ��¼��ǰ�ָ�����ҵ�������ʲô
	            
	            // ��ߵ�l1 ����nums1 ��cut1 - 1λ���ϵ����֣��Դ�����
	            // ���cut1 == 0�� ����˼��nums1û�а취�ָ�ָ��������ߣ����û������
	            // �����Ǿ͹��⽫�����ó���С�ģ�����֮����Զ��case 1
	            // ˵�����ǲ�����
	            
	            // ������뷨��ʵ������
	            // ��������nums1�ķָ�������ұߣ���˵��֮ǰ�϶��Ƿָ��һֱ��������
	            // ������Ѿ��������ұߵĻ������Ǿÿ��԰��ĵİ�R1 ���óɶ�һ���ܴ�����֣� ������ʹ��ͷ�ļ����ˣ��ָ���ȷ������Ҳ֪��Ӧ������һ��R����Ϊ��
	            // ˵�����ǲ���Ų
	            double L1 = (cut1 == 0) ? Integer.MIN_VALUE : nums1[cut1 - 1];
	            double L2 = (cut2 == 0) ? Integer.MIN_VALUE : nums2[cut2 - 1];
	            double R1 = (cut1 == l1) ? Integer.MAX_VALUE : nums1[cut1];
	            double R2 = (cut2 == l2) ? Integer.MAX_VALUE : nums2[cut2];

	            // case 1��
	            if (L1 > R2) {
	                // ˵�����ǵ����ֻ���̫���ˣ�����Ų
	                cutR = cut1 - 1;
	            
	            //case 2
	            } else if (R1 < L2) {
	                // ˵�����ǵ�����̫С�ˣ�����Ų
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
