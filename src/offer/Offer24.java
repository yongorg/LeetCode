package offer;

import util.ListNode;

import java.util.LinkedList;

/**
 * @Author yongz
 * @Date 2020/9/2、22:21
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *  
 * <p>
 * 限制：
 * <p>
 * 0 <= 节点个数 <= 5000
 */
public class Offer24 {

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < 10000; i++)
            list.add(0);
        long start = System.nanoTime();
        while (!list.isEmpty())
            list.remove(list.size() / 2);
        System.out.println((System.nanoTime() - start) / 1000000000.0 + " s");

        System.out.println();

        list = new LinkedList<>();
        for (int i = 0; i < 100000; i++)
            list.add(0);
        start = System.nanoTime();
        while (!list.isEmpty())
            list.remove(list.size() / 2);
        System.out.println((System.nanoTime() - start) / 1000000000.0 + " s");
    }

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：39.7 MB, 在所有 Java 提交中击败了26.41%的用户
     *
     * @param head
     * @return
     */
    public ListNode reverseList1(ListNode head) {

        if (head == null || head.next == null) return head;
        // 链表反转本质就是把指针指向前面那个，然后返回最后那个节点即可
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode delNode = cur.next;
            cur.next = prev;
            prev = cur;
            cur = delNode;
        }
        return prev;

    }

    /**
     * 递归法
     *
     * @param head
     * @return
     */
    public ListNode reverseList4(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode result = head;
        while (result.next != null) {
            result = result.next;
        }

        reverseList2(head);
        return result;
    }


    public static ListNode reverseList2(ListNode head) {

        if (head.next == null) return head;
        ListNode cur = head; // 当前节点
        ListNode listNode = reverseList2(cur.next);
        cur.next.next = cur;//将反转的链表指向当前cur节点
        cur.next = null;
        return listNode;
    }


    /**
     * 递归法
     */
    public ListNode reverseList(ListNode head) {

        if (head == null || head.next == null) return head;
        ListNode p = reverseList(head.next);
        //head.next既当前节点（5），将其下一节点指向前一节点（4）
        head.next.next = head;
        //将前一节点（4）指向null
        head.next = null;
        //返回固定节点（5）
        return p;
    }

}
