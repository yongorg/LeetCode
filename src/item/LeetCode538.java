package item;

import javax.swing.tree.TreeNode;
import java.util.Stack;

/**
 * @Author yongz
 * @Date 2020/9/21、14:06
 * 538. 把二叉搜索树转换为累加树
 * 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
 * 例如：
 * <p>
 * 输入: 原始二叉搜索树:
 * 5
 * /   \
 * 2     13
 * <p>
 * 输出: 转换为累加树:
 * 18
 * /   \
 * 20     13
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class LeetCode538 {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }


    }


    // 反向中序递归法
    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
    }

    // 反向中序非递归法
    public TreeNode convertBST2(TreeNode root) {
        if (root == null) return root;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode right = root.right;
        while (right != null) {
            stack.push(right);
            right = right.right;
        }

        // 先把左边全部节点压入栈
        while (!stack.isEmpty()) {
            TreeNode inCul = stack.pop();
            sum += inCul.val;
            inCul.val = sum;
            if (inCul.left != null) {
                stack.push(inCul.left);
                TreeNode temp = inCul.left.right;
                while (temp != null) {
                    stack.push(temp);
                    temp = temp.right;
                }
            }
        }
        return root;

    }
}
