package item;

import javax.lang.model.element.VariableElement;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author yongz
 * @Date 2020/8/25、1:00
 *给定一个整型数组, 你的任务是找到所有该数组的递增子序列，递增子序列的长度至少是2。
 *
 * 示例:
 *
 * 输入: [4, 6, 7, 7]
 * 输出: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
 * 说明:
 *
 * 给定数组的长度不会超过15。
 * 数组中的整数范围是 [-100,100]。
 * 给定数组中可能包含重复数字，相等的数字应该被视为递增的一种情况。
 *
 */
public class LeetCode491 {


    public static void main(String[] args) {

    }

    /**
     * 暴力解决法
     * @param nums
     * @return
     */
    public static List<List<Integer>> findSubsequences(int[] nums) {
        int len = nums.length;
        List<List<Integer>> lists = new ArrayList();

        for (int i = 0; i < len- 1; i++) {
            // 先找两个的
            for (int j = i; j <len- 1; j++) {

            }
        }


        return lists;
    }

}
