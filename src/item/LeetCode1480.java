package item;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.concurrent.ForkJoinPool;

/**
 * @Author yongz
 * @Date 2020/9/2、14:15
 */
public class LeetCode1480 {

    public static void main(String[] args) {

        int[] nums = {1,2,3,4};
        int[] ints = runningSum1(nums);
        System.out.println(Arrays.toString(ints));

    }



    /**
     *
     *  遍历法求解！
     * @param nums
     * @return
     * O(n²)
     * 执行结果：通过
     *
     * 执行用时：4 ms  , 在所有 Java 提交中击败了7.60%的用户
     * 内存消耗：40.2 MB, 在所有 Java 提交中击败了12.28%的用户
     */
    public static int[] runningSum(int[] nums) {
        int n = nums.length;
        int[] runningSum = new int[n];

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j <= i; j++) {
                sum+=nums[j];
            }
            runningSum[i] = sum;
        }
        return runningSum;
    }


    /**
     * 优化遍历求解，本质上不需要再进行第二层遍历了
     * @param nums
     * @return
     * 执行结果：
     * 通过
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
     * 内存消耗：39.7 MB, 在所有 Java 提交中击败了的 86.87%用户
     */
    public static int[] runningSum1(int[] nums) {
        int n = nums.length;
        int[] runningSum = new int[n];
        runningSum[0] = nums[0];// 第一个和就是num[0]
        for (int i = 1; i < n; i++) {
            runningSum[i] = runningSum[i-1]+nums[i];// 第i个和就是num[i]+runningSum[i-1]
        }
        return runningSum;
    }

    /**
     * 递归求解
     *执行结果：通过
     *执行用时：0 ms  , 在所有 Java 提交中击败了100%的用户
     *内存消耗：40.2 MB, 在所有 Java 提交中击败了7.03%的用户
     * @param nums
     * @return
     */
    public  int[] runningSum2(int[] nums) {
        int n = nums.length;
        int[] runningSum = new int[n];

        // 每次求数组的和即可
        sumArr(runningSum,nums,n-1);

        return runningSum;
    }

    private  int sumArr(int[] runningSum,int[] nums, int index) {
        if (index == 0) {
            runningSum[0] = nums[0];
            return nums[0];
        }
        runningSum[index] = nums[index]+ sumArr(runningSum, nums, index - 1);
        return runningSum[index];
    }

}
