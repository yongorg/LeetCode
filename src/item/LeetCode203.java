package item;


import util.ListNode;

/**
 * @Author yongz
 * @Date 2020/8/30、20:32
 */
public class LeetCode203 {


    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 3, 4, 6, 6, 7};
        ListNode listNode1 = new ListNode(arr);


        ListNode listNode = new LeetCode203().removeElements(null, 1);
        System.out.println(listNode);
    }


    // 不设置虚拟头节点
    public ListNode removeElements1(ListNode head, int val) {

        while (head != null && head.val == val) {
            ListNode delNode = head;
            head = head.next;
            delNode.next = null;
        }
        if (head == null) return null;

        ListNode prev = head;
        while (prev.next != null) {
            if (prev.next.val == val) {
                ListNode delNode = prev.next;
                prev.next = delNode.next;
                delNode.next = null;
            } else {
                prev = prev.next;
            }
        }
        return head;
    }

    // 虚拟头节点
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode prev = dummyHead;

        while (prev.next != null) {
            if (prev.next.val == val) {
                ListNode del = prev.next;
                prev.next = del.next;
                del.next = null;
            } else {
                prev = prev.next;
            }
        }

        return dummyHead.next;

    }

    public ListNode result;

    // 递归解决
// 递归解决
    public ListNode removeElements3(ListNode head, int val) {

        if (head == null)
            return null;
        head.next = removeElements3(head.next, val);
        return head.val == val? head.next:head;

    }


}

