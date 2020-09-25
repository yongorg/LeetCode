package item;

import java.util.List;

/**
 * @Author yongz
 * @Date 2020/9/21、16:55
 */
public class LeetCode559_N叉树的最大深度 {
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

    public int maxDepth(Node root) {
        if (root == null) return 0;
        List<Node> children = root.children;
        int maxDepth = 0;
        for (Node child : children) {
            int temp = maxDepth(child);
            if (temp > maxDepth)
                maxDepth = temp;
        }
        return maxDepth + 1;
    }
}
