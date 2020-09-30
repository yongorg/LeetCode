package item;

import util.TreeNode;

public class LeetCode235_二叉搜索树的最近公共祖先 {



    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode result = root;

        while (true) {

            if (result.val > p.val && result.val > q.val)
                result = result.left;
            else  if (result.val < p.val && result.val < q.val)
                result = result.right;
            else
                break;
        }

        return result;
    }
}
