package item;

import util.TreeNode;

/**
 * @Author yongz
 * @Date 2020/9/21、15:54
 * 617. 合并二叉树
 * 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
 * <p>
 * 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点。
 */
public class LeetCode617 {

    public TreeNode mergeTrees1(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return null;

        int t1val = t1 == null ? 0 : t1.val;
        int t2val = t2 == null ? 0 : t2.val;
        TreeNode node = new TreeNode(t1val + t2val);
        node.left = mergeTrees(t1 == null ? null : t1.left, t2 == null ? null : t2.left);
        node.right = mergeTrees(t1 == null ? null : t1.right, t2 == null ? null : t2.right);
        return node;
    }

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return null;

        int t1val = t1 == null ? 0 : t1.val;
        int t2val = t2 == null ? 0 : t2.val;
        TreeNode node = new TreeNode(t1val + t2val);
        if (t1 == null) {
            node.left = t2.left;
            node.right = t2.right;
        } else if (t2 == null) {
            node.left = t1.left;
            node.right = t1.right;
        }else {
            node.left = mergeTrees(t1.left, t2.left);
            node.right =mergeTrees(t1.right, t2.right);
        }

        return node;
    }
}
