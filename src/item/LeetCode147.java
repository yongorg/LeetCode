package item;

import util.ListNode;

import javax.lang.model.element.VariableElement;
import java.lang.invoke.LambdaConversionException;
import java.util.ArrayList;

/**
 * @Author yongz
 * @Date 2020/9/2、17:07
 * 147. 对链表进行插入排序
 *  
 * <p>
 * 插入排序算法：
 * <p>
 * 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
 * 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
 * 重复直到所有输入数据插入完为止。
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例 2：
 * <p>
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 */
public class LeetCode147 {


    public static void main(String[] args) {
        int[] temp = {4, 1, 6, 0, 5};
//        int[] temp = {0, 1, 2, 3, 4, 5};
        ListNode listNode = new ListNode(temp);

        System.out.println(insertionSortList(listNode));
    }


    // 循环不变量0，i已排序。 链表转数组的插入排序法
    public static ListNode insertionSortList(ListNode head) {

        if (head== null || head.next== null)return head;
        ArrayList<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(0, head.val);
            head = head.next;
        }
        for (int i = 1; i < list.size(); i++) {
            Integer temp = list.get(i);
            int j = i;
            for (; j > 0 && list.get(j - 1) > temp; j--) {
                list.set(j, list.get(j - 1));
            }
            list.set(j, temp);
        }

        ListNode relHead = new ListNode(list.get(0));

        ListNode cur = relHead;
        for (int i = 1; i < list.size(); i++) {
            cur.next = new ListNode(list.get(i));
            cur = cur.next;
        }
        return relHead;
    }

    // 将节点插入到合适的位置
    public static ListNode insertionSortList2(ListNode head) {
        if (head== null || head.next== null)return head;

        ListNode pre=head;                  //使用前驱节点pre便于后续节点的删除操作
        ListNode cur=head.next;           //使用当前节点cur
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next=head;
        while ( cur != null){
            if (pre.val<cur.val){                   //前后节点已经有序，无需重排
                pre=cur;
                cur=cur.next;
            } else {
                ListNode p=dummyHead;
                while (p.next!=cur &&p.next.val<cur.val)
                    p=p.next;
                pre.next=cur.next;         //删除当前节点
                cur.next=p.next;          //将当前节点连接到对应位置
                p.next=cur;
                cur=pre.next;
            }


        }


        return dummyHead.next;
    }


}
