package item;

import util.ListNode;

/**
 * @Author yongz
 * @Date 2020/9/2、16:38
 */
public class LeetCode237 {
    private static ListNode head;

    public static void main(String[] args) {
        int[] temp = {1, 2, 4, 6, 8};
        head = new ListNode(temp);
        ListNode listNode = new ListNode(1);
        System.out.println(listNode);
        deleteNode(listNode);
        System.out.println(head);
    }


    // 带头节点遍历法
    public static void deleteNode(ListNode node) {

        ListNode root = new ListNode(0);
        root.next = head;
        // 寻址
        while (root.next != null) {
            if (root.next.val == node.val) {
                root.next = root.next.next;
            }
            root = root.next;
        }

    }

}
