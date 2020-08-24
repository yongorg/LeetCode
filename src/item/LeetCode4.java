package item;

import java.util.Arrays;

/**
 * @Author yongz
 * @Date 2020/8/24、20:58
 * <p>
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
 * <p>
 * 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * <p>
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * nums1 = [1, 3]
 * nums2 = [2]
 * <p>
 * 则中位数是 2.0
 * 示例 2:
 * <p>
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * <p>
 * 则中位数是 (2 + 3)/2 = 2.5
 */
public class LeetCode4 {

    public static void main(String[] args) {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        System.out.println(findMedianSortedArrays1(nums1,nums2));
        int[] nums3 = {1, 2};
        int[] nums5 = {3,4};
        System.out.println(findMedianSortedArrays1(nums3,nums5));
    }
    /**
     * 方法二 合并数组再排序
     * 先不考虑时间复杂度和空间复杂度，合并数组找中位数
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int[] ints = new int[nums1.length + nums2.length];
        int i= 0;
        for (int num1: nums1)
            ints[i++] = num1;
        for (int num2: nums2)
            ints[i++] = num2;

        // 快速排序法
        quickSort(ints, 0 , ints.length-1);

        // 返回新数组的中位数
        if (ints.length % 2 == 1) {
            return ints[ints.length / 2 ];
        } else {
            return (ints[ints.length / 2] + ints[ints.length / 2 - 1]) / 2.0;
        }
    }

    /**
     * 快速排序法
     * @param arr
     * @param start
     * @param end
     */
    public static void quickSort(int[] arr, int start, int end) {
        if (end <= start) {
            return;
        }
        int low = start;
        int high = end;
        int pivot = arr[low];
        while (low < high) {
            while (low < high && arr[high] >= pivot) {
                high--;
            }
            arr[low] = arr[high]; // 将小于 pivot 的数放在地位
            while (low < high && arr[low] <= pivot) {
                low++;
            }
            arr[high] = arr[low]; // 将大于 pivot 的数放在高位
        }
        arr[low] = pivot;
        quickSort(arr, start, low - 1); // 递归排序左半部分
        quickSort(arr, low + 1, end); // 递归排序右半部分
    }



    /**
     * 方法一 暴力求解
     * 先不考虑时间复杂度和空间复杂度，合并数组找中位数
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] ints = new int[nums1.length + nums2.length];
        int index1 = 0, index2 = 0;
        // 合并数组
        for (int i = 0; i < ints.length; i++) {
            if (index1 > nums1.length - 1) {
                ints[i] = nums2[index2];
                index2++;
                continue;
            }
            if (index2 > nums2.length - 1) {
                ints[i] = nums1[index1];
                index1++;
                continue;
            }
            if (nums1[index1] < nums2[index2]) {
                ints[i] = nums1[index1];
                index1++;
            } else {
                ints[i] = nums2[index2];
                index2++;
            }
        }

        // 返回新数组的中位数
        if (ints.length % 2 == 1) {
            return ints[ints.length / 2 ];
        } else {
            return (ints[ints.length / 2] + ints[ints.length / 2 - 1]) / 2.0;
        }

    }
}
