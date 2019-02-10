package microsoft;

import java.util.HashMap;

public class CopyRandomPointerLinkedList {
	
	// time: N
	// Space N
	// Recursive
	public class Solution {
		// 用于记录走过的node
	    public HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
	    public RandomListNode copyRandomList(RandomListNode head) {
	        if (head == null) {
	            return null;
	        }
	        
	        // 如果map中已经有过了这个node，那就将已知的对应的value给他
	        if (map.containsKey(head)) {
	            return map.get(head);
	        }
	        
	        // 创建一个新的node来代表当前的node
	        // 这个node将会是我们最后的答案
	        RandomListNode temp = new RandomListNode(head.label);
	        
	        // 将head和temp对应起来
	        map.put(head, temp);
	        
	        // temp的next和random可以用recursive的方法继续traverse
	        temp.next = copyRandomList(head.next);
	        temp.random = copyRandomList(head.random);
	        
	        return temp;
	    }
	}
	
	/**
	 * Definition for singly-linked list with a random pointer.
	 * class RandomListNode {
	 *     int label;
	 *     RandomListNode next, random;
	 *     RandomListNode(int x) { this.label = x; }
	 * };
	 */
	public class Solution2 {
	    public RandomListNode copyRandomList(RandomListNode head) {
	        if (head == null) {
	            return null;
	        }
	        
	        RandomListNode temp = head;
	        
	        while (temp != null) {
	            RandomListNode ans = new RandomListNode(temp.label);
	            ans.next = temp.next;
	            temp.next = ans;
	            temp = ans.next;
	        }
	        
	        RandomListNode temp2 = head;
	        
	        while (temp2 != null) {
	            temp2.next.random = (temp2.random != null) ? temp2.random.next : null;
	            temp2 = temp2.next.next;
	        }
	        
	        RandomListNode temp3 = head;
	        RandomListNode temp4 = head.next;
	        RandomListNode ans = head.next;
	        while (temp3 != null) {
	            temp3.next = temp3.next.next;
	            temp4.next = (temp4.next != null) ? temp4.next.next : null;
	            temp3 = temp3.next;
	            temp4 = temp4.next;
	        }
	        return ans;
	    }
	}
}

