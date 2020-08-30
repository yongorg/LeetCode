package util;

/**
 * @Author yongz
 * @Date 2020/8/30、21:28
 */
public class ListNode {
    public int val;
    public ListNode next;

    public  ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        ListNode temp = this;
        while (temp != null) {
            sb.append(temp.val);
            sb.append("-->");
            temp = temp.next;
        }
        sb.append("null");
        return sb.toString();
    }

    public ListNode(int[] arr) {
        if (arr == null || arr.length == 0)
            throw new IllegalArgumentException("arr cannt be empty");

        this.val = arr[0];
        ListNode cur = this;
        for (int i : arr) {
            cur.next = new ListNode(i);
            cur = cur.next;
        }
    }




    /**
     * 循环迭代法
     *
     * @param listNode
     * @return
     */
    public static ListNode getOrderDesc(ListNode listNode) {
        ListNode temp = listNode;
        ListNode lastTemp = null; // 记录原listNode的前一个节点
        while (temp != null) {
            ListNode back = temp.next; // 备份下一节点
            temp.next = lastTemp;//把
            lastTemp = temp;
            temp = back; //用于遍历循环
        }
        return lastTemp;
    }

    /**
     * 递归法
     *
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        //递归到最下一层获得末尾节点
        if (head == null || head.next == null) return head;
        //每次递归完成后head都会往前移位
        ListNode p = reverseList(head.next);
        //head.next既当前节点（5），将其下一节点指向前一节点（4）
        head.next.next = head;
        //将前一节点（4）指向null
        head.next = null;
        //返回固定节点（5）
        return p;
    }
}
