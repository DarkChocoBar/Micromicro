package other;

public class AddTwoNumbers {
	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode(int x) { val = x; }
	 * }
	 */
	class Solution {
	    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	        
	        // ��Ϊpointer �����б���
	        ListNode p1 = l1;
	        ListNode p2 = l2;
	        
	        // ˼·�� ������һ���յ�listnode����Ϊͷ����p����¼���ͷ
	        // p����һ�����Ǵ�������ʼ��node
	        ListNode res = new ListNode(0);
	        ListNode p = res;
	        int remain = 0;
	        
	        // �������������������null��ʱ����ֹͣwhile
	        while (p1 != null || p2 != null) {
	            int sum = 0;
	            
	            // �����ּ�����
	            if (p1 != null) {
	                sum += p1.val;
	                p1 = p1.next;
	            }
	            if (p2 != null) {
	                sum += p2.val;
	                p2 = p2.next;
	            }
	            
	            // ��¼����10������
	            int curr = (sum + remain) % 10;
	            res.next = new ListNode(curr);
	            // ����Ҫ��¼
	            remain = (sum + remain) / 10;
	            //�ƶ�����һ����������
	            res = res.next;
	        }
	        
	        // ��������0��ʱ��˵���������𰸵Ĵ����������ڶ�λ�Ǹ�0����߻��и�1���Ǿ�����ǰ���һ��1����
	        if (remain > 0) {
	            res.next = new ListNode(remain);
	        }
	        
	        // �ظ����մ�
	        return p.next;
	    }
	}
}
