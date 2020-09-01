package item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author yongz
 * @Date 2020/8/27、13:49
 */
public class Test {

    public static void main(String[] args) {
        List<String> list;
        List<List<String>> tickets = new ArrayList<>();
//        String[][] test = {{"MUC", "LHR"}, {"JFK", "MUC"}, {"SFO", "SJC"}, {"LHR", "SFO"}};
//        String[][] test = {{"JFK", "SFO"}, {"JFK", "ATL"}, {"SFO", "ATL"}, {"ATL", "JFK"}, {"ATL", "SFO"}};
        String[][] test ={{"JFK","ATL"},{"ORD","PHL"},{"JFK","ORD"},{"PHX","LAX"},{"LAX","JFK"},{"PHL","ATL"},{"ATL","PHX"}};
//        String[][] test = {{"JFK", "KUL"}, {"JFK", "NRT"}, {"NRT", "JFK"}};
//        String[][] test = {{"JFK", "SFO"}, {"JFK", "ATL"}, {"SFO", "ATL"}, {"ATL", "JFK"}, {"ATL", "SFO"}};
        for (String[] t : test) {
            list = new ArrayList<>();
            for (String s : t) {
                list.add(s);
            }
            tickets.add(list);
        }


        System.out.println(tickets);
        List<String> itinerary = new Solution(). findItinerary(tickets);
        System.out.println(itinerary);
    }


}

class Solution {



    public  int endIndex;
    /**
     * 先找头，在根据头出发,而这一题是确定了头
     *
     * @param tickets
     * @return
     */
    public  List<String> findItinerary(List<List<String>> tickets) {
        LinkedList<String> result = new LinkedList<>(); // 记录返回值

        findEnd(tickets);//找最后一个目的端的所在位置;
        List<String> remove = tickets.remove(endIndex);
        // 写个递归依次查找下去即可
        findNext("JFK", tickets, result);
        result.addLast(remove.get(1));//把最后的目的端插入

        return result;
    }

    private  void findEnd(List<List<String>> tickets) {
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
    public  void findNext(String last, List<List<String>> tickets, List<String> result) {
        result.add(last); // 添加上一个


        if (tickets.size() == 0) return;
        int index = -1;
        for (int i = 0; i < tickets.size(); i++) {

            if (tickets.get(i).get(0).equals(last) ) { // 最后一个不要
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

}
