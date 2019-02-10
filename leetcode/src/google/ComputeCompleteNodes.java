package google;


// 222


public class ComputeCompleteNodes {
	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	class Solution {
	    public int countNodes(TreeNode root) {
	        int leftD = leftDepth(root);
	        int leftR = rightDepth(root);
	        
	        if (leftD != leftR) {
	            return 1 + countNodes(root.left) + countNodes(root.right);
	        } else {
	            return (1 << leftD) - 1;
	        }
	    }
	    
	    public int leftDepth(TreeNode root) {
	        int ans = 0;
	        while (root != null) {
	            root = root.left;
	            ans++;
	        }
	        
	        return ans;
	    }
	    
	    public int rightDepth(TreeNode root) {
	        int ans = 0;
	        while (root != null) {
	            root = root.right;
	            ans++;
	        }
	        
	        return ans;
	    }
	}
	
	class Solution2 {
	    public int countNodes(TreeNode root) {
	        int leftD = leftDepth(root);
	        int leftR = rightDepth(root);
	        
	        if (leftD != leftR) {
	            return 1 + countNodes(root.left) + countNodes(root.right);
	        } else {
	            return (1 << leftD) - 1;
	        }
	    }
	    
	    public int leftDepth(TreeNode root) {
	        int ans = 0;
	        while (root != null) {
	            root = root.left;
	            ans++;
	        }
	        
	        return ans;
	    }
	    
	    public int rightDepth(TreeNode root) {
	        int ans = 0;
	        while (root != null) {
	            root = root.right;
	            ans++;
	        }
	        
	        return ans;
	    }
	}
}
