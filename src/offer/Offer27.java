package offer;


/**
 * @Author yongz
 * @Date 2020/9/21、15:23
 */
public class Offer27 {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public TreeNode mirrorTree(TreeNode root) {

        if (root == null) return root;

        TreeNode right = root.right;
        root.right = root.left;
        root.left = right;
        mirrorTree(root.left);
        mirrorTree(root.right);
        return root;
    }
}
