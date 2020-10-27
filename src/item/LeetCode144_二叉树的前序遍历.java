package item;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author yongz
 * @Date 2020/10/27、15:10
 */
public class LeetCode144_二叉树的前序遍历 {
    public List<Integer> preorderTraversal1(TreeNode root) {
        ArrayList<Integer> rel = new ArrayList<>();
        preorderTraversal(root, rel);
        return rel;
    }

    // 递归
    private void preorderTraversal(TreeNode root, List<Integer> rel) {
        if (root == null) return;
        rel.add(root.val);
        preorderTraversal(root.left, rel);
        preorderTraversal(root.right, rel);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node1.right = node2;
        node2.left = node3;
        preorderTraversal(node1);
    }

    // 非递归法，模拟栈
    public static List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> rel = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if (root == null) return rel;
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode pop = stack.pop();
            rel.add(pop.val);
            if (pop.right!= null)
                stack.push(pop.right);
            if (pop.left!= null)
                stack.push(pop.left);
        }
        return rel;
    }


}
