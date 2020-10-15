package item;

import org.omg.CORBA.IRObject;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Author yongz
 * @Date 2020/10/15、11:39
 * <p>
 * 注意：
 * 你只能使用常量级额外空间。
 * 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
 */
public class LeetCode116_填充每个节点的下一个右侧节点指针 {
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


    // 广度优先遍历
    public Node connect1(Node root) {
        if (root == null) return root;
        Queue<Node> queue = new LinkedList<>();

        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node tempNode = queue.remove();
                if (tempNode.left != null) queue.add(tempNode.left);
                if (tempNode.right != null) queue.add(tempNode.right);
                tempNode.next = i == size - 1 ? null : queue.peek();
            }
        }
        return root;
    }

    public Node connect2(Node root) {
        if (root == null)
            return root;
        //cur我们可以把它看做是每一层的链表
        Node cur = root;
        while (cur != null) {
            //遍历当前层的时候，为了方便操作在下一 层前面添加一个哑结点（注意这里是访问 当前层的节点，然后把下一层的节点串起来）
            Node dummy = new Node(0);
            //pre表示访下一层节点的前一个节点
            Node pre = dummy;

            //然后开始遍历当前层的链表 因为是完没二叉树，如果有左子节点就一定有右子节点
            while (cur != null && cur.left != null) {
                //让pre节点的next指向当前节点的左子节点，也就是把它串起来
                pre.next = cur.left;
                //然后再更新pre
                pre = pre.next;

                //pre节点的next指向当前节点的右子节点，
                pre.next = cur.right;
                pre = pre.next;
                //继续访问这一行的下一个节点
                cur = cur.next;
            }
            //把下一层串联成一个链表之后，让他赋值给cur，
            //后续继续循环，直到cur为空为止
            cur = dummy.next;
        }
        return root;
    }


    public Node connect(Node root) {
        if (root == null) {
            return root;
        }

        // 从根节点开始
        Node leftmost = root;

        while (leftmost.left != null) {

            // 遍历这一层节点组织成的链表，为下一层的节点更新 next 指针
            Node head = leftmost;

            while (head != null) {

                // CONNECTION 1
                head.left.next = head.right;

                // CONNECTION 2
                if (head.next != null) {
                    head.right.next = head.next.left;
                }

                // 指针向后移动
                head = head.next;
            }

            // 去下一层的最左的节点
            leftmost = leftmost.left;
        }

        return root;
    }


}

