package other;


public class constructbinarytreefromPreandIn {
	  //Definition for a binary tree node.
	  public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	 }

	class Solution {
	    public TreeNode buildTree(int[] preorder, int[] inorder) {        
	        return helper(preorder, inorder, 0, 0, preorder.length - 1);
	    }
	    
	    public TreeNode helper(int[] preorder, int[] inorder, int pre_st,int in_st,int in_end) {
	        if (pre_st > preorder.length - 1 || in_st > in_end) {
	            return null;
	        }
	        TreeNode root = new TreeNode(preorder[pre_st]);
	        int i = 0;
	        for (int index = in_st; index <= in_end; index++) {
	            if (preorder[pre_st] == inorder[index]) {
	                i = index;
	                break;
	            }
	        }
	        
	        root.left = helper(preorder, inorder, pre_st + 1, in_st, i - 1);
	        root.right = helper(preorder, inorder, pre_st + i - in_st + 1, i + 1, in_end);
	        return root;
	    }
	}
}
