package item;

import util.TreeNode;

/**
 * @Author yongz
 * @Date 2020/9/21、15:50
 */
public class LeetCode226 {

    public TreeNode invertTree(TreeNode root) {

        if (root == null) return root;

        TreeNode right = root.right;
        root.right = root.left;
        root.left = right;

        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
