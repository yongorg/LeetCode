package offer;

import javax.swing.tree.TreeNode;

/**
 * @Author yongz
 * @Date 2020/9/21、15:18
 * 二叉树的最大深度
 */
public class Offer55_I {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
