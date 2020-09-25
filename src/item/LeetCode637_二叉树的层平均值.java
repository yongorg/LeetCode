package item;

import util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author yongz
 * @Date 2020/9/22、16:05
 */
public class LeetCode637_二叉树的层平均值 {

    // 层序遍历--广度优先遍历
    public List<Double> averageOfLevels(TreeNode root) {
        //
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        ArrayList<Double> list = new ArrayList<>();
        TreeNode node;
        double sum;
        while (!queue.isEmpty()) {
            int size = queue.size();
            sum = 0;
            for (int i = 0; i < size; i++) {
                node = queue.remove();
                sum += node.val;
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            list.add(sum / size);
        }
        return list;
    }
}
