package other;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import other.populateNextRightPointer.TreeLinkNode;

public class populateNextRightPointer {
	/**
	 * Definition for binary tree with next pointer.
	 * public class TreeLinkNode {
	 *     int val;
	 *     TreeLinkNode left, right, next;
	 *     TreeLinkNode(int x) { val = x; }
	 * }
	 */
	 public class TreeLinkNode {
	      int val;
	      TreeLinkNode left, right, next;
	      TreeLinkNode(int x) { val = x; }
	 }
	 
	 // BFS经典题， 每个level的node都加入q中，遍历+设定next的值
	public class Solution {
	    public void connect(TreeLinkNode root) {
	        if (root == null) {
	            return;
	        }
	        
	        Queue<TreeLinkNode> q = new LinkedList<TreeLinkNode>();
	        q.add(root);
	        while (!q.isEmpty()) {
	            ArrayList<TreeLinkNode> arr = new ArrayList<TreeLinkNode>();
	            System.out.println("array INITIALIZED is: " + arr.size());
	            System.out.println("queue start size is: " + q.size());
	            int size = q.size();
	            for (int i = 0; i < size; i++) {
	                TreeLinkNode temp = q.poll();
	                arr.add(temp);
	                System.out.println("array1 end size is: " + arr.size());
	                System.out.println("inputed: " + temp.val);
	                if (temp.left != null) {
	                    q.add(temp.left);
	                }
	                if (temp.right != null) {
	                    q.add(temp.right);
	                }
	            }
	            System.out.println("array2 end size is: " + arr.size());
	            for (int j = 0; j < arr.size() - 1; j++) {
	                
	                arr.get(j).next = arr.get(j + 1);
	            }
	            System.out.println("array3 end size is: " + arr.size());
	            arr.get(arr.size() - 1).next = null;
	        }
	    }
	}
}
