package item;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author yongz
 * @Date 2020/9/29、11:52
 */
public class LeetCode145_二叉树的后序遍历 {
    public static void main(String[] args) {


    }
    // 迭代法
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if (root == null) return ret;

        Stack<TreeNode> stack = new Stack();
        stack.push(root);
        // 先把左树全都压如栈中
        while (stack.peek().left != null){
            stack.push(stack.peek().left);
        }

        while (!stack.isEmpty()){

            //从栈中取出元素
            TreeNode pop = stack.pop();
            if (pop.right == null){
                ret.add(pop.val);
            }else {
                TreeNode right = pop.right;
                pop.right = null;
                stack.push(pop);
                stack.push(right);
                while (stack.peek().left != null){
                    stack.push(stack.peek().left);
                }
            }
        }

        return ret;
    }


    // 递归
    public List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        postorderTraversal(root, ret);

        return ret;
    }

    private void postorderTraversal(TreeNode root, List<Integer> ret) {
        if (root == null)
            return;
        postorderTraversal(root.left, ret);
        postorderTraversal(root.right, ret);
        ret.add(root.val);
    }
}
