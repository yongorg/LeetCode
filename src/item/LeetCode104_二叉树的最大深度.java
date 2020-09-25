package item;

import util.TreeNode;

/**
 * @Author yongz
 * @Date 2020/9/21、16:21
 */
public class LeetCode104_二叉树的最大深度 {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
