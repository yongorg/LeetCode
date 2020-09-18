package offer;

import item.LeetCode215;

import java.util.Arrays;
import java.util.Random;

/**
 * 剑指 Offer 40. 最小的k个数
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 * 示例 2：
 * <p>
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 */
public class Offer40 {

    public static void main(String[] args) {
        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int[] kthLargest = new Offer40().getLeastNumbers(nums, 2);
        System.out.println(Arrays.toString(kthLargest));
    }

    public int[] getLeastNumbers(int[] arr, int k) {

        if(k == 0) return new int[0];

        Random rnd = new Random();
        selectK(arr, 0, arr.length - 1, k - 1, rnd);

        return Arrays.copyOf(arr, k);
    }

    private int selectK(int[] arr, int l, int r, int k, Random rnd){

        int p = partition(arr, l, r, rnd);

        if(k == p) return arr[p];

        if(k < p) return selectK(arr, l, p - 1, k, rnd);
        return selectK(arr, p + 1, r, k, rnd);
    }

    private int partition(int[] arr, int l, int r, Random rnd){

        // 生成 [l, r] 之间的随机索引
        int p = l + rnd.nextInt(r - l + 1);
        swap(arr, l, p);

        // arr[l+1...i-1] <= v; arr[j+1...r] >= v
        int i = l + 1, j = r;
        while(true){

            while(i <= j && arr[i] < arr[l])
                i ++;

            while(j >= i && arr[j] > arr[l])
                j --;

            if(i >= j) break;

            swap(arr, i, j);

            i ++;
            j --;
        }

        swap(arr, l, j);
        return j;
    }

    private void swap(int[] arr, int i, int j){

        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
