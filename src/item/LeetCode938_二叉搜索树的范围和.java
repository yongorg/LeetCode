package item;

import util.TreeNode;

/**
 * @Author yongz
 * @Date 2020/9/21、16:06
 */
public class LeetCode938_二叉搜索树的范围和 {

    int sum = 0;

    // 前序遍历
    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) return sum;

        if (root.val >= L && root.val <= R)
            sum += root.val;
        if (root.val >= L)
            rangeSumBST(root.left, L, R);
        if (root.val <= R)
            rangeSumBST(root.right, L, R);
        return sum;
    }


    // 前序遍历
    public int rangeSumBST2(TreeNode root, int L, int R) {
        if (root == null) return 0;
        int val = 0;
        if (root.val >= L && root.val <= R)
            val = root.val;
        if (root.val >= L)
            val = root.val + rangeSumBST(root.left, L, R);
        if (root.val <= R)
            val = root.val + rangeSumBST(root.right, L, R);
        return val;
    }

}
