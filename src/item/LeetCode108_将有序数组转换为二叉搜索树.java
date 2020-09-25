package item;

import util.TreeNode;

/**
 * @Author yongz
 * @Date 2020/9/21、16:28
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 * <p>
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 */
public class LeetCode108_将有序数组转换为二叉搜索树 {
    public TreeNode sortedArrayToBST(int[] nums) {
       return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    public TreeNode sortedArrayToBST(int[] nums, int l, int r) {

        if (l > r) return null;

        int mid = l + (r - l) / 2;
        TreeNode node = new TreeNode(nums[mid]);

        node.left = sortedArrayToBST(nums, l, mid - 1);
        node.right = sortedArrayToBST(nums, mid + 1, r);

        return node;
    }
}
