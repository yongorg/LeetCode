package item;

import util.ListNode;

import java.util.ArrayList;

/**
 * @Author yongz
 * @Date 2020/8/19、19:56
 * <p>
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class LeetCode2 {



    public static void main(String[] args) {
        ListNode listNode1 = null;

        listNode1 = new ListNode(2);
        ListNode listNodex = listNode1;
        ListNode listNode2 = new ListNode(4);
        ListNode listNode3 = new ListNode(3);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = new ListNode(6);

        ListNode listNode4 = new ListNode(5);
        ListNode listNode5 = new ListNode(6);
        ListNode listNode6 = new ListNode(4);
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        System.out.println(listNode1);
        ListNode orderDesc = ListNode.getOrderDesc(listNode1);
        System.out.println(listNode1);
        System.out.println(orderDesc);
        ListNode listNode = new LeetCode2().addTwoNumbers(new ListNode(5), new ListNode(5));

    }


    /**
     * 通过ArrayList存储每位结果节点，然后再组装链表，均有空间与时间浪费，但是好理解
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {

        int x = 0; //用于记录是否有进1 位
        ArrayList<ListNode> listNodes = new ArrayList<>(); // 存储每个节点
        while (true) {
            if (l1 != null && l2 != null) { //两个链表均还值的情况
                int sum = l1.val + l2.val + x; // 各位相加
                listNodes.add(new ListNode(sum % 10)); //每1位的节点
                x = sum / 10; // 取进1位
                l1 = l1.next;
                l2 = l2.next;
            } else if (l1 == null && l2 == null && x == 0) {//两个链表均无值并且也无进位值，表示计算完毕退出循环
                break;
            } else if (l1 == null && l2 == null && x != 0) { //两个链表均无值并且，但上一位有进1位的情况
                listNodes.add(new ListNode(x));
            } else if (l1 == null && l2 != null) {//一个链表有值，一个链表无值的情况
                int sum = l2.val + x;
                x = sum / 10;
                listNodes.add(new ListNode(sum % 10));
                l2 = l2.next;
            } else if (l1 != null && l2 == null) {//一个链表有值，一个链表无值的情况
                int sum = l1.val + x;
                x = sum / 10;
                listNodes.add(new ListNode(sum % 10));
                l1 = l1.next;
            }
        }

        // 拼装节点
        for (int i = 0; i < listNodes.size() - 1; i++) {
            listNodes.get(i).next = listNodes.get(i + 1);
        }
        return listNodes.get(0);
    }

    /**
     * 原地构建list，内存空间超出
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {

        int x = 0;
        ListNode root = new ListNode(0); //用于取两个链表数据
        ListNode temp3 = root; //记录当前temp3第一个节点的对象，以便返回
        while (true) {
            if (l1 != null && l2 != null) {
                int sum = l1.val + l2.val + x;
//                listNodes.add(new ListNode(sum % 10));
                temp3.next = new ListNode(sum % 10);
                x = sum / 10;
                l1 = l2.next;
                l1 = l2.next;
            } else if (l1 == null && l2 == null && x == 0) {
                break;
            } else if (l1 == null && l2 == null && x != 0) {
//                listNodes.add(new ListNode(x));
                temp3.next = new ListNode(x);
            } else if (l1 == null && l2 != null) {
                int sum = l2.val + x;
                x = sum / 10;
//                listNodes.add(new ListNode(sum % 10));
                temp3.next = new ListNode(sum % 10);
                l2 = l2.next;
            } else if (l1 != null && l2 == null) {
                int sum = l1.val + x;
                x = sum / 10;
//                listNodes.add(new ListNode(sum % 10));
                temp3.next = new ListNode(sum % 10);
                l1 = l1.next;
            }
            temp3 = temp3.next;

        }

        return root.next;
    }


    /**
     * 原地构建list，上续再优化
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers3(ListNode l1, ListNode l2) {
        int x = 0;
        ListNode root = new ListNode(0); //用于取两个链表数据
        ListNode temp3 = root; //记录当前temp3第一个节点的对象，以便返回
        while (true) {
            if (l1 != null && l2 != null) {
                int sum = l1.val + l2.val + x;
//                listNodes.add(new ListNode(sum % 10));
                temp3.next = new ListNode(sum % 10);
                x = sum / 10;
                l1 = l1.next;
                l2 = l2.next;
            } else if (l1 == null && l2 == null && x == 0) {
                break;
            } else if (l1 == null && l2 == null && x != 0) {
//                listNodes.add(new ListNode(x));
                temp3.next = new ListNode(x);
            } else if (l1 == null && l2 != null) {
                int sum = l2.val + x;
                x = sum / 10;
//                listNodes.add(new ListNode(sum % 10));
                temp3.next = new ListNode(sum % 10);
                l2 = l2.next;
            } else if (l1 != null && l2 == null) {
                int sum = l1.val + x;
                x = sum / 10;
//                listNodes.add(new ListNode(sum % 10));
                temp3.next = new ListNode(sum % 10);
                l1 = l1.next;
            }
            temp3 = temp3.next;

        }

        return root.next;
    }


    /**
     * 原地组装，上续流程再优化
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers4(ListNode l1, ListNode l2) {
        int x = 0;
        ListNode root = new ListNode(0); //返回的链表根节点
        ListNode temp3 = root; //用于操作组装链表
        while (l1 != null || l2 != null || x != 0) { //如果两个链表和进位均无值则表示计算结束，退出循环
            int l1val = l1 != null ? l1.val : 0; //获取l1链表的值，null即为0
            int l2val = l2 != null ? l2.val : 0; //获取l2链表的值，null即为0
            int sum = l1val + l2val + x; // l1与l2各位求和
            x = sum / 10;//计算进位
            temp3.next = new ListNode(sum % 10);//计算当前位的和
            l1 = l1 != null ? l1.next : l1;//l1 当前是否为null，不为null继续获取下一位
            l2 = l2 != null ? l2.next : l2;//l2 当前是否为null，不为null继续获取下一位
            temp3 = temp3.next;
        }
        return root.next;//返回根节点后的链表即为返回的链表
    }


    /**
     * 原地组装，上续流程再优化
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int x = 0;
        ListNode root = l1; //
        while (l1.val != -1 || l2 != null || x != 0) { //如果两个链表和进位均无值则表示计算结束，退出循环
            int l1val = l1.val != -1 ? l1.val : 0; //获取l1链表的值，null即为0
            int l2val = l2 != null ? l2.val : 0; //获取l2链表的值，null即为0
            int sum = l1val + l2val + x; // l1与l2各位求和
            x = sum / 10;//计算进位
            l2 = l2 != null ? l2.next : l2;//l2 当前是否为null，不为null继续获取下一位
            l1.val = sum % 10;//计算当前位的和
            if (l2 == null && x == 0) break;
            l1.next = l1.next == null ? new ListNode(-1) : l1.next;
            l1 = l1.next;

        }
        return root;//返回根节点后的链表即为返回的链表
    }


}



