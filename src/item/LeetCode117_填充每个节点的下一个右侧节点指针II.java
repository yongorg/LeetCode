package item;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author yongz
 * @Date 2020/9/28、10:30
 */
public class LeetCode117_填充每个节点的下一个右侧节点指针II {
    private class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    ;


    public Node connect(Node root) {
        if (root==null) return root;
        Node rel = root;
        Queue<Node> queue = new LinkedList();

        queue.add(root);

        while (!queue.isEmpty()) {
            Node perv;
            Node cur = null;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                perv = cur;
                cur = queue.remove();
                if (perv != null)
                    perv.next = cur;

                if (cur.left != null)
                    queue.add(cur.left);
                if (cur.right != null)
                    queue.add(cur.right);
            }

        }

        return rel;
    }
}
