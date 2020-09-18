package item;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author yongz
 * @Date 2020/9/10、10:20
 * 40. 组合总和 II
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用一次。
 *
 * 说明：
 *
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。
 * 示例 1:
 *
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 */
public class LeetCode40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        //数组排序
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        // 深度优先搜索
        dfs(0, candidates.length - 1, 0, new ArrayList<>(), result, target, candidates);
        return result;
    }


    // 深度优先搜索
    public void dfs(int start, int n, int sum, ArrayList<Integer> resultData, List result, int target, int[] candidates) {
        if (sum == target) {
            result.add(new ArrayList<>(resultData));
            return;
        }
        if (sum > target) {
            return;
        }

        for (int i = start; i <= n; i++) {
            if (sum + candidates[i] > target) continue;

            if (i - 1 >= start && candidates[i] == candidates[i - 1]) continue; // 保证数据不重复

            resultData.add(candidates[i]);
            dfs(i + 1, n, sum + candidates[i], resultData, result, target, candidates);
            resultData.remove(resultData.size() - 1);
        }
    }
}
