package item;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author yongz
 * @Date 2020/8/19、14:33
 *
 *
 * 1. 两数之和
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 */
public class SumOfTwoNumbers {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,2, 7, 8, 15};
//        int[] ints = solution.twoSum(nums, 9);
//        System.out.println(Arrays.toString(ints));
    }
}
//
//class Solution {
//    /**
//     * 遍历所有元素对比
//     * @param nums
//     * @param target
//     * @return
//     */
//    public int[] twoSum1(int[] nums, int target) {
//
//        for (int i = 0; i <nums.length-1; i++) {
//            for (int j = i; j < nums.length-1; j++) {
//                if (target == nums[i]+nums[j]) return new int[]{i,j};
//            }
//        }
//        throw new IllegalArgumentException("No two sum solution");
//    }
//
//
//    /**
//     * 空间换时间
//     * 使用哈希表，通过以空间换取速度的方式，我们可以将查找时间从 O(n)降低到 O(1)。
//     * @param nums
//     * @param target
//     * @return
//     */
//    public int[] twoSum(int[] nums, int target) {
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            int complement = target - nums[i];
//            if (map.containsKey(complement)) {
//                return new int[] { map.get(complement), i };
//            }
//            map.put(nums[i], i);
//        }
//        throw new IllegalArgumentException("No two sum solution");
//    }
//}
//
