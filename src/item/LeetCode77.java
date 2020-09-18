package item;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author yongz
 * @Date 2020/9/8、13:13
 */
public class LeetCode77 {
    public static void main(String[] args) {
        LeetCode77 leetCode77 = new LeetCode77();
        List<List<Integer>> combine = leetCode77.combine(4, 3);
        System.out.println(combine);
    }

    public List<List<Integer>> combine1(int n, int k) {
        List<List<Integer>> result = new ArrayList<>(k);
        dfs1(1, n, k, new ArrayList<>(),  result);
        return result;
    }

    // 深度优先搜索
    public void dfs1(int start, int n, int k, ArrayList<Integer> resultData, List result) {
        if (k == 0) return;
        if (k == 1) {
            for (int i = start; i <= n; i++) {
                ArrayList<Integer> copyList = copyList(resultData);
                copyList.add(i);
                result.add(copyList);
            }
            return;
        }

        for (int i = start; i <= n; i++) {
            ArrayList<Integer> copyList = copyList(resultData);
            copyList.add(i);
            dfs1(i + 1, n, k - 1, copyList,result);
        }
    }

    public ArrayList<Integer> copyList(ArrayList<Integer> list) {
        ArrayList<Integer> copyList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            copyList.add(list.get(i));
        }
        return copyList;
    }




    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>(k);
        dfs(1, n, k, new ArrayList<>(),  result);
        return result;
    }

    // 深度优先搜索
    public void dfs(int start, int n, int k, ArrayList<Integer> resultData, List result) {
        if (k == 0) {
            result.add(new ArrayList<>(resultData));
        }

        for (int i = start; i <= n; i++) {
            resultData.add(i);
            dfs(i + 1, n, k - 1, resultData,result);
            resultData.remove(resultData.size()-1);
        }
    }



}
