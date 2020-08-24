package item;

import util.ArrayUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author yongz
 * @Date 2020/8/19、19:33
 * <p>
 * <p>
 * 1. 两数之和
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * <p>
 * <p>
 * 示例:
 * <p>
 * 给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class LeetCode1 {

    public static void main(String[] args) {
        LeetCode1 solution = new LeetCode1();
        int[] nums = ArrayUtil.getRandomArray(100000);  //构建一个长度未100000条记录的数组


        long start = System.nanoTime();
        solution.twoSum1(nums, 10000000);//传入不可能找得到target
        long end = System.nanoTime();
        System.out.println((end - start )/ 1000000000.0+"秒");   //2.0264468秒


        start = System.nanoTime();
        solution.twoSum(nums, 10000000);//传入不可能找得到target
        end = System.nanoTime();
        System.out.println((end - start )/ 1000000000.0 +"秒"); // 0.0345863秒

    }


    /**
     * 遍历所有元素对比
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum1(int[] nums, int target) {

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i; j < nums.length - 1; j++) {
                if (target == nums[i] + nums[j]) return new int[]{i, j};
            }
        }
        return  null;
//        throw new IllegalArgumentException("No two sum solution");
    }


    /**
     * 空间换时间
     * 使用哈希表，通过以空间换取速度的方式，我们可以将查找时间从 O(n)降低到 O(1)。
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();//hash

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return  null;
//        throw new IllegalArgumentException("No two sum solution");
    }
}



