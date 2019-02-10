package other;

public class lowestcommonancestor {
	/**
	 * Definition for a binary tree node.

	 * }
	 */
	
	// 找到对应的p或者q的时候，直接return 当前的root/node
	// divide and concur， 左右分开来做
	// post order的做法。 先检查两边的node，然后再判断是否找到公约数。
	  public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	class Solution {
	    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
	        if (root == null) {
	            return null;
	        }
	        if (root == p || root == q) {
	            return root;
	        }
	        TreeNode left = lowestCommonAncestor(root.left, p, q);
	        TreeNode right = lowestCommonAncestor(root.right, p, q);
	        
	        if (left != null && right != null) {
	            return root;
	        } 
	        
	        if (left == null) {
	            return right;
	        }

	        if (right == null) {
	            return left;
	        }
	        return null;
	    }
	    
	}
	 }
}
