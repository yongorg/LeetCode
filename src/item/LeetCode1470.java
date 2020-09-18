package item;

import java.util.Arrays;

/**
 * @Author yongz
 * @Date 2020/9/10、10:53
 * 1470. 重新排列数组
 * 给你一个数组 nums ，数组中有 2n 个元素，按 [x1,x2,...,xn,y1,y2,...,yn] 的格式排列。
 * <p>
 * 请你将数组按 [x1,y1,x2,y2,...,xn,yn] 格式重新排列，返回重排后的数组。
 */
public class LeetCode1470 {

    public static void main(String[] args) {
        int[] test = {2, 5, 1, 3, 4, 7};
        int[] shuffle = shuffle(test, 3);
        System.out.println(Arrays.toString(shuffle));
    }

    // 方法一暴力解决，非原地排列
    public static int[] shuffle(int[] nums, int n) {
        int[] result = new int[2 * n];
        for (int i = 0; i < n; i++) {
            result[i * 2] = nums[i];
            result[i * 2 + 1] = nums[i + n];
        }
        return result;
    }

}
