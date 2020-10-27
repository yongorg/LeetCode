package item;

import java.util.PriorityQueue;

/**
 * @Author yongz
 * @Date 2020/10/16、9:42
 * 659. 分割数组为连续子序列
 * 给你一个按升序排序的整数数组 num（可能包含重复数字），请你将它们分割成一个或多个子序列，其中每个子序列都由连续整数组成且长度至少为 3 。
 *
 * 如果可以完成上述分割，则返回 true ；否则，返回 false 。
 *
 *
 *
 * 示例 1：
 *
 * 输入: [1,2,3,3,4,5]
 * 输出: True
 * 解释:
 * 你可以分割出这样两个连续子序列 :
 * 1, 2, 3
 * 3, 4, 5
 *
 *
 * 示例 2：
 *
 * 输入: [1,2,3,3,4,4,5,5]
 * 输出: True
 * 解释:
 * 你可以分割出这样两个连续子序列 :
 * 1, 2, 3, 4, 5
 * 3, 4, 5
 *
 *
 * 示例 3：
 *
 * 输入: [1,2,3,4,4,5]
 * 输出: False
 *
 */
public class LeetCode659_分割数组为连续子序列 {
    public static void main(String[] args) {
        LeetCode659_分割数组为连续子序列 test = new LeetCode659_分割数组为连续子序列();
        int[] arr = {1,2,3,4,4,5,6};
        boolean possible = test.isPossible(arr);
        System.out.println(possible);

    }
    public boolean isPossible(int[] nums) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++)
            minHeap.add(nums[i]);

        int length = 0;
        while (!minHeap.isEmpty()){
            Integer poll = minHeap.poll();
            System.out.println(poll);
        }



        return true;
    }
}
