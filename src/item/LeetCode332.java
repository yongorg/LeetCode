package item;

import javax.lang.model.element.VariableElement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author yongz
 * @Date 2020/8/27、10:34
 * 给定一个机票的字符串二维数组 [from, to]，子数组中的两个成员分别表示飞机出发和降落的机场地点，对该行程进行重新规划排序。所有这些机票都属于一个从 JFK（肯尼迪国际机场）出发的先生，所以该行程必须从 JFK 开始。
 * <p>
 * 说明:
 * <p>
 * 如果存在多种有效的行程，你可以按字符自然排序返回最小的行程组合。例如，行程 ["JFK", "LGA"] 与 ["JFK", "LGB"] 相比就更小，排序更靠前
 * 所有的机场都用三个大写字母表示（机场代码）。
 * 假定所有机票至少存在一种合理的行程。
 * 示例 1:
 * <p>
 * 输入: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
 * 输出: ["JFK", "MUC", "LHR", "SFO", "SJC"]
 * 示例 2:
 * <p>
 * 输入: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
 * 输出: ["JFK","ATL","JFK","SFO","ATL","SFO"]
 * 解释: 另一种有效的行程是 ["JFK","SFO","ATL","JFK","ATL","SFO"]。但是它自然排序更大更靠后。
 */
public class LeetCode332 {

    public static void main(String[] args) {
        List<String> list;
        List<List<String>> tickets = new ArrayList<>();
//        String[][] test = {{"MUC", "LHR"}, {"JFK", "MUC"}, {"SFO", "SJC"}, {"LHR", "SFO"}};
//        String[][] test = {{"JFK", "SFO"}, {"JFK", "ATL"}, {"SFO", "ATL"}, {"ATL", "JFK"}, {"ATL", "SFO"}};

//        String[][] test = {{"JFK", "KUL"}, {"JFK", "NRT"}, {"NRT", "JFK"}};
        String[][] test = {{"JFK", "ATL"},{"JFK", "SFO"},  {"SFO", "ATL"}, {"ATL", "SFO"}, {"ATL", "JFK"}};
        for (String[] t : test) {
            list = new ArrayList<>();
            for (String s : t) {
                list.add(s);
            }
            tickets.add(list);
        }


        System.out.println(tickets);
        List<String> itinerary = findItinerary(tickets);
        System.out.println(itinerary);
    }


    public static int endIndex;
    /**
     * 先找头，在根据头出发,而这一题是确定了头
     *
     * @param tickets
     * @return
     */
    public static List<String> findItinerary(List<List<String>> tickets) {
        LinkedList<String> result = new LinkedList<>(); // 记录返回值

        findEnd(tickets);//找最后一个目的端的所在位置;
//        System.out.println(endIndex);
        // 写个递归依次查找下去即可
        findNext("JFK", tickets, result);
        result.addLast(tickets.get(0).get(1));//把最后的目的端插入
        return result;
    }

    private static void findEnd(List<List<String>> tickets) {
        HashMap<String, Integer> hashmap = new HashMap<>();

        for (List<String> ticket : tickets) {
            hashmap.put(ticket.get(1), hashmap.get(ticket.get(1)) == null ? 1 : hashmap.get(ticket.get(1)) + 1);
            hashmap.put(ticket.get(0), hashmap.get(ticket.get(0)) == null ? 1 : hashmap.get(ticket.get(0)) + 1);
        }
        hashmap.put("JFK", hashmap.get("JFK") - 1);
        String end = null;
        for (String s : hashmap.keySet()) {
            if (hashmap.get(s) % 2 != 0) {
                end = s;
            }
        }

        for (int i = 0; i < tickets.size(); i++) {
            if (tickets.get(i).get(1).equals(end)) {
                if (endIndex == 0) {
                    endIndex = i;
                } else if (tickets.get(i).get(0).compareTo(tickets.get(endIndex).get(0)) > 0) {
                    endIndex = i;
                }

            }
        }
    }


    /**
     * 上续提交，不能通过leetcode测试用例，原因看实例2要求
     */
    public static void findNext(String last, List<List<String>> tickets, List<String> result) {
        result.add(last); // 添加上一个

        if (tickets.size() == 1) return;
        int index = -1;
        for (int i = 0; i < tickets.size(); i++) {

            if (tickets.get(i).get(0).equals(last) && i != endIndex) { // 最后一个不要
                if (index == -1) {
                    index = i;
                } else if (tickets.get(i).get(1).compareTo(tickets.get(index).get(1)) < 0)// 根据实例2要求排序
                {
                    index = i;
                }
            }
        }


        List<String> temp = tickets.remove(index);
        findNext(temp.get(1), tickets, result);//依次向下找
    }

    

    public static void findNext1(String last, List<List<String>> tickets, List<String> result) {
        result.add(last); // 添加上一个
        if (tickets.size() == 0) return;
        int i = 0;
        for (; i < tickets.size(); i++) {
            List<String> ticket = tickets.get(i);
            String s1 = ticket.get(0);
            if (s1.equals(last)) break;
        }


        List<String> ticket = tickets.get(i);
        tickets.remove(i);
        findNext(ticket.get(1), tickets, result);//依次向下找
    }

    /**
     * 上续优化下代码结构
     */
    public static void findNext2(String last, List<List<String>> tickets, List<String> result) {
        result.add(last); // 添加上一个
        if (tickets.size() == 0) return;
        int i = 0;
        for (; i < tickets.size(); i++) {
            if (tickets.get(i).get(0).equals(last)) break;
        }
        List<String> temp = tickets.remove(i);
        findNext2(temp.get(1), tickets, result);//依次向下找
    }

}
