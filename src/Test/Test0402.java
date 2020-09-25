package Test;

import offer.Offer27;

/**
 * @Author yongz
 * @Date 2020/9/21、15:31
 * 面试题 04.02. 最小高度树
 * 给定一个有序整数数组，元素各不相同且按升序排列，编写一个算法，创建一棵高度最小的二叉搜索树。
 * <p>
 * 示例:
 * 给定有序数组: [-10,-3,0,5,9],
 * <p>
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 * <p>
 * 0
 * / \
 * -3   9
 * /   /
 * -10  5
 */
public class Test0402 {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        int[] nums = {-10, -3, 0,3, 5, 9};
        TreeNode node = new Test0402().sortedArrayToBST(nums);
        inOrder(node);
    }

    public static void inOrder(TreeNode node) {
        if (node == null) return;

        inOrder(node.left);

        inOrder(node.right);
        System.out.print(node.val + "\t");
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    private TreeNode sortedArrayToBST(int[] nums, int l, int r) {
        if (l > r) return null;
        int mid = l + (r - l) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = sortedArrayToBST(nums, l, mid - 1);
        node.right = sortedArrayToBST(nums, mid + 1, r);
        return node;
    }
}
