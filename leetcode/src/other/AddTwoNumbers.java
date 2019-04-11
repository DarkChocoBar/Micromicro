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
	        
	        // 作为pointer 来进行遍历
	        ListNode p1 = l1;
	        ListNode p2 = l2;
	        
	        // 思路： 我们用一个空的listnode来作为头，用p来记录这个头
	        // p的下一个才是答案真正开始的node
	        ListNode res = new ListNode(0);
	        ListNode p = res;
	        int remain = 0;
	        
	        // 经典遍历，当两个都是null的时候再停止while
	        while (p1 != null || p2 != null) {
	            int sum = 0;
	            
	            // 将数字加起来
	            if (p1 != null) {
	                sum += p1.val;
	                p1 = p1.next;
	            }
	            if (p2 != null) {
	                sum += p2.val;
	                p2 = p2.next;
	            }
	            
	            // 记录超过10的数字
	            int curr = (sum + remain) % 10;
	            res.next = new ListNode(curr);
	            // 余数要记录
	            remain = (sum + remain) / 10;
	            //移动到下一个继续遍历
	            res = res.next;
	        }
	        
	        // 余数大于0的时候说明我们最后答案的从左往右数第二位是个0，左边还有个1，那就在最前面加一个1就行
	        if (remain > 0) {
	            res.next = new ListNode(remain);
	        }
	        
	        // 回复最终答案
	        return p.next;
	    }
	}
}
