package other;

public class lowestcommonancestor {
	/**
	 * Definition for a binary tree node.

	 * }
	 */
	
	// �ҵ���Ӧ��p����q��ʱ��ֱ��return ��ǰ��root/node
	// divide and concur�� ���ҷֿ�����
	// post order�������� �ȼ�����ߵ�node��Ȼ�����ж��Ƿ��ҵ���Լ����
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