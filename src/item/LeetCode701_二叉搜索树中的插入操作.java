package item;

import util.TreeNode;

import java.util.Queue;

/**
 * @Author yongz
 * @Date 2020/9/30、9:05
 */
public class LeetCode701_二叉搜索树中的插入操作 {

    // 递归法
    public TreeNode insertIntoBST1(TreeNode root, int val) {

        if (root == null) return new TreeNode(val);

        if (val > root.val) {
            root.right = insertIntoBST1(root.right, val);
        }
        if (val < root.val) {
            root.left = insertIntoBST1(root.left, val);
        }
        return root;
    }

    // 迭代法
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        TreeNode prev = root;

        while (prev != null) {
            if (prev.val == val) {
                return root;
            } else if (val < prev.val) {
                if (prev.left != null)
                    prev = prev.left;
                else {
                    prev.left = new TreeNode(val);
                    break;
                }
            } else {
                if (prev.right != null)
                    prev = prev.right;
                else {
                    prev.right = new TreeNode(val);
                    break;
                }

            }
        }

        return root;
    }

}
