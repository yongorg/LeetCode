package item;

import util.ListNode;

import java.lang.management.ManagementFactory;
import java.util.HashSet;

/**
 * @Author yongz
 * @Date 2020/10/9、9:18
 */
public class LeetCode141_环形链表 {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        System.out.println(set.add(new String("123456")));
        System.out.println(set.add(new String("123456")));
        System.out.println(set.add(new String("123456")));
        System.out.println(set.add(new String("123456")));
    }

    public boolean hasCycle(ListNode head) {

        if (head == null) return false;
        HashSet<ListNode> set = new HashSet<>();
        set.add(head);
        while (head.next != null) {
            if (!set.add(head.next)) return true;
            head = head.next;
        }
        return false;
    }
}
