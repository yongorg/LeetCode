package item;

import util.TreeNode;

import java.util.HashMap;

/**
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 * <p>
 * 注意:
 * 你可以假设树中没有重复的元素。
 * <p>
 * 例如，给出
 * <p>
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 返回如下的二叉树：
 * <p>
 *         3
 *        / \
 *       9  20
 *          /  \
 *         15   7
 * https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/solution/tu-jie-gou-zao-er-cha-shu-wei-wan-dai-xu-by-user72/
 */
public class LeetCode106_从中序与后序遍历序列构造二叉树 {
    public static void main(String[] args) {

        int[] inorder = {10, 9, 3, 15, 20, 7};
        int[] postorder = {10, 9, 15, 7, 20, 3};
        LeetCode106_从中序与后序遍历序列构造二叉树 test = new LeetCode106_从中序与后序遍历序列构造二叉树();
        TreeNode node = test.buildTree(inorder, postorder);
        TreeNode.inOrder(node);
        System.out.println();
        TreeNode.postOrder(node);
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++)
            map.put(inorder[i], i);

        return buildTree(map, 0, postorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode buildTree(HashMap<Integer, Integer> inorder, int il, int ir, int[] postorder, int pl, int pr) {
        if (il > ir) return null;
        if (il == ir) return new TreeNode(postorder[pr]);
        TreeNode root = new TreeNode(postorder[pr]);
        int mid = inorder.get(postorder[pr]);

        //int leftCount = mid - il; //左子树节点个数
        //int rightCount = ir - mid;//右子树节点个数
        //root.left = buildTree(inorder, il, mid - 1, postorder, pl, pl + leftCount - 1);
        //root.right = buildTree(inorder, mid + 1, ir, postorder, pl + leftCount, pl + leftCount + rightCount - 1);
        root.left = buildTree(inorder, il, mid - 1, postorder, pl, pl + mid - il - 1);
        root.right = buildTree(inorder, mid + 1, ir, postorder, pl + mid - il, pl - il + ir - 1);
        return root;
    }
}
