package item;

import java.util.Random;

/**
 * @Author yongz
 * @Date 2020/9/17、15:36
 */
public class LeetCode215 {
    public static void main(String[] args) {
        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int kthLargest = new LeetCode215().findKthLargest(nums, 2);
        System.out.println(kthLargest);
    }

    private static Random random = new Random();

    public int findKthLargest(int[] nums, int k) {
        return selectK(nums, 0, nums.length - 1, nums.length - k);
    }


    private int selectK(int[] nums, int l, int r, int k) {
        int p = partition2Ways(nums, l, r);
        if (k == p) return nums[p];
        if (k < p) return selectK(nums, l, p - 1, k);
        return selectK(nums, p + 1, r, k);
    }

    private int partition2Ways(int[] arrays, int l, int r) {
        // 随机值
        int p = random.nextInt(r - l + 1) + l;
        swap(arrays, p, l);

        // arr[l+1...i-1] <= v; arr[j+1...r] >= v
        int temp = arrays[l];
        int i = l + 1;
        int j = r;
        while (true) {
            while (i <= j && arrays[i] < temp)
                i++;
            while (i <= j && arrays[j] > temp)
                j--;

            if (i >= j) break;
            swap(arrays, i, j);
            i++;
            j--;
        }
        swap(arrays, l, j);
        return j;
    }


    private static void swap(int[] list, int i, int j) {
        int temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }
}
