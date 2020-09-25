package item;

import util.TreeNode;

import java.util.*;

/**
 * @Author yongz
 * @Date 2020/9/21、17:15
 */
public class LeetCode98_验证二叉搜索树 {


//    public boolean isValidBST(TreeNode root) {
//        ArrayList<Integer> list = new ArrayList<>();
//        isValidBST(root,list);
//        for (int i = 1; i < list.size(); i++) {
//            if (list.get(i) <= list.get(i - 1)) return false;
//        }
//        return true;
//    }
//
//    // 中序遍历是否是有序
//    private void isValidBST(TreeNode node, List list) {
//        if (node == null) return;
//        isValidBST(node.left,list);
//        list.add(node.val);
//        isValidBST(node.right,list);
//    }


    public boolean isValidBST(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        double inorder = -Double.MAX_VALUE;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            // 如果中序遍历得到的节点的值小于等于前一个 inorder，说明不是二叉搜索树
            if (root.val <= inorder) {
                return false;
            }
            inorder = root.val;
            root = root.right;
        }
        return true;
    }

}
