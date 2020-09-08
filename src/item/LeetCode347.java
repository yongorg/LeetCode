package item;

import jdk.nashorn.internal.ir.IfNode;

import javax.swing.*;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @Author yongz
 * @Date 2020/9/7、13:26
 * 347. 前 K 个高频元素
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 * <p>
 * 输入: nums = [1], k = 1
 * 输出: [1]
 * <p>
 * <p>
 * 提示：
 * 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 * 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。
 * 你可以按任意顺序返回答案。
 */
public class LeetCode347 {


    public static void main(String[] args) {
        int[] arr = { 2, 3, 3, 5, 7, 7, 1};
        int[] ints = new LeetCode347().topKFrequent1(arr, 2);
        System.out.println(Arrays.toString(ints));
    }

    //
    public int[] topKFrequent1(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap();

        for (int i = 0; i < nums.length; i++) {
            Integer value = map.get(nums[i]);
            if(value == null) value = 0;
            map.put(nums[i],value+1);
        }

        int[] result = new int[k];

        getTop1(map,result,k);


        return result;
    }

    public void getTop1(HashMap<Integer,Integer> map, int[] result,int k) {
        if (k == 0) return;

        int maxVaule = 0;
        int maxKey= 0;
        Integer temp ;
        for (Integer key : map.keySet()) {
            temp = map.get(key);
            if (temp >maxVaule) {
                maxVaule = temp;
                maxKey = key;
            }
        }
        result[k-1] = maxKey;
        map.remove(maxKey);
        getTop1( map, result, k-1);
    }

    // 采用归并排序数组，再找出来前n
    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        int[] copyData = Arrays.copyOf(nums, nums.length);
        mergeSort(nums, 0, nums.length - 1, copyData);


        return null;
    }

    private void mergeSort(int[] nums, int l, int r, int[] copyData) {
        if (l >= r) {

            return;
        }

        int mid = (l + r) / 2;


        mergeSort(nums, l, mid, copyData);

        mergeSort(nums, mid + 1, r, copyData);

        if (nums[mid] > nums[mid + 1])
            // 合并数组
            merge(nums, l, mid, r, copyData);
    }

    private void merge(int[] nums, int l, int mid, int r, int[] copyData) {
        for (int i = l; i <= r; i++) {
            copyData[i] = nums[i];
        }

        int i = l;
        int j = mid + 1;
        for (int k = l; k < r + 1; k++) {
            if (i > mid)
                nums[k] = copyData[j++];
            else if (j > r)
                nums[k] = copyData[i++];
            else
                nums[k] = copyData[i] <= copyData[j] ? copyData[i++] : copyData[j++];
        }


    }

}
