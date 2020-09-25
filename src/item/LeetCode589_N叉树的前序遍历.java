package item;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author yongz
 * @Date 2020/9/21、17:02
 */
public class LeetCode589_N叉树的前序遍历 {
    private class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public List<Integer> preorder(Node root) {
        ArrayList list = new ArrayList<Node>();
        preorder(root, list);
        return list;
    }

    public void preorder(Node root, ArrayList list) {
        if (root == null) return;
        list.add(root.val);
        for (Node child : root.children) {
            preorder(child,list);
        }
    }
}
