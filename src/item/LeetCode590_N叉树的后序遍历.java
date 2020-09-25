package item;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author yongz
 * @Date 2020/9/21、17:11
 */
public class LeetCode590_N叉树的后序遍历 {
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
    public List<Integer> postorder(Node root) {
        ArrayList list = new ArrayList();
        postorder(root, list);
        return list;
    }

    public void postorder(Node root,List list) {
        if (root == null) return;
        for (Node child : root.children) {
            postorder(child,list);
        }
        list.add(root.val);
    }
}
