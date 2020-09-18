package item;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author yongz
 * @Date 2020/9/9、18:54
 * 39. 组合总和
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取。
 *
 * 说明：
 *
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。
 * 示例 1：
 *
 * 输入：candidates = [2,3,6,7], target = 7,
 * 所求解集为：
 * [
 *   [7],
 *   [2,2,3]
 * ]
 * 示例 2：
 *
 * 输入：candidates = [2,3,5], target = 8,
 * 所求解集为：
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 *
 *
 * 提示：
 *
 * 1 <= candidates.length <= 30
 * 1 <= candidates[i] <= 200
 * candidate 中的每个元素都是独一无二的。
 * 1 <= target <= 500
 */
public class LeetCode39 {

    public static void main(String[] args) {

        int [] a = {2,3,5};

        LeetCode39 leetCode39 = new LeetCode39();
        List<List<Integer>> lists = leetCode39.combinationSum( a, 8);

        System.out.println(lists);

    }


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(0, candidates.length-1,  new ArrayList<>(),  result,0,target,candidates);
        return result;
    }



    // 深度优先搜索
    public void dfs(int start, int n,  ArrayList<Integer> resultData, List result,int sum ,int target, int[] candidates) {
        if (sum == target) {
            result.add(new ArrayList<>(resultData));
        }

        for (int i = start; i <= n; i++) {
            if (sum +candidates[i] > target ) continue;
            resultData.add(candidates[i]);
            dfs(i, n,  resultData,result,sum+ candidates[i],target,candidates);
            resultData.remove(resultData.size()-1);
        }
    }
}
