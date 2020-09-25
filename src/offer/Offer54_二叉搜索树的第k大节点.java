package offer;

import util.TreeNode;

/**
 * @Author yongz
 * @Date 2020/9/21、16:32
 */
public class Offer54_二叉搜索树的第k大节点 {
    int kdepth = 0;
    int result = 0;

    // 反向中序遍历
    public int kthLargest(TreeNode root, int k) {
        if (root == null) return 0;
        kthLargest(root.right, k);
        kdepth++;
        if (kdepth == k)
            result = root.val;
        if (kdepth > k)
            return result;
        kthLargest(root.left, k);
        return result;
    }
}
