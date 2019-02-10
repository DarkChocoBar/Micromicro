package other;


public class constructBTfromInorderandPostorder {
	  public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	 }
	class Solution {
	    public TreeNode buildTree(int[] inorder, int[] postorder) {
	        return helper(postorder, inorder, postorder.length - 1, 0, postorder.length - 1);
	    }
	    
	    public TreeNode helper(int[] postorder, int[] inorder, int post_st,int in_st,int in_end) {
	        if (post_st < 0 || in_st > in_end) {
	            return null;
	        }
	        TreeNode root = new TreeNode(postorder[post_st]);
	        int i = 0;
	        for (int index = in_st; index <= in_end; index++) {
	            if (postorder[post_st] == inorder[index]) {
	                i = index;
	                break;
	            }
	        }
	        
	        // ע�������index��post order��������ͷ��Զ��post_st - 1
	        // ������Զ�ǵ�ǰͷ����index ��ȥ inorder���ڿ���subarray��β�˼�ȥͷ�����ֵ�index �ټ�һ
	        root.left = helper(postorder, inorder, post_st - (in_end - i) - 1, in_st, i - 1);
	        root.right = helper(postorder, inorder, post_st - 1, i + 1, in_end);
	        return root;
	    }
	}
}
