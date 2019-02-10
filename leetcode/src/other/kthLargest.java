package other;

public class kthLargest {

}






// inefficient solution of mine
class KthLargestNum {
    TreeNode root;
    int k;
    public KthLargestNum(int k, int[] nums) {
        this.k = k;
        for (int num: nums) root = add(root, num);
    }

    public int add(int val) {
        root = add(root, val);
        return findKthLargest();
    }

    private TreeNode add(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        root.count++;
        if (val < root.val) root.left = add(root.left, val);
        else root.right = add(root.right, val);

        return root;
    }

    public int findKthLargest() {
        int count = k;
        TreeNode walker = root;

        while (count > 0) {
            int pos = 1 + (walker.right != null ? walker.right.count : 0);
            if (count == pos) break;
            if (count > pos) {
                count -= pos;
                walker = walker.left;
            } else if (count < pos)
                walker = walker.right;
        }
        return walker.val;
    }

    class TreeNode {
        int val, count = 1;
        TreeNode left, right;
        TreeNode(int v) { val = v; }
    }
}