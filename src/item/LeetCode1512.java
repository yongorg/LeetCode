package item;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ForkJoinPool;

/**
 * @Author yongz
 * @Date 2020/9/10、10:44
 */
public class LeetCode1512 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1, 1, 3};
        int i = numIdenticalPairs(nums);
        System.out.println(i);
    }

    // 解法1：暴力求解
    public static int numIdenticalPairs(int[] nums) {
        int result = 0;

        for (int i = 0; i < nums.length; i++)
            for (int j = i+1; j < nums.length; j++)
                if (nums[i] == nums[j])
                    result++;

        return result;
    }


    // 解法2：hash解决。空间换时间
    public int numIdenticalPairs2(int[] nums) {
        Map<Integer, Integer> m = new HashMap<Integer, Integer>();
        for (int num : nums) {
            m.put(num, m.getOrDefault(num, 0) + 1);
        }

        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : m.entrySet()) {
            int v = entry.getValue();
            ans += v * (v - 1) / 2;
        }

        return ans;
    }


}
