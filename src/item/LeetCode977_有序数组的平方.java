package item;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @Author yongz
 * @Date 2020/10/16、9:20
 */
public class LeetCode977_有序数组的平方 {


    public int[] sortedSquares1(int[] A) {
        for (int i = 0; i < A.length; i++)
            A[i] = A[i] * A[i];
        Arrays.sort(A);
        return A;
    }

    // 双指针求解，时间、空间复杂度均为O(n)
    public int[] sortedSquares(int[] A) {
        int n = A.length;
        int index = n - 1;
        int[] rel = new int[n];

        for (int i = 0, j = n - 1; i <= j; ) {
            if (A[i] * A[i] > A[j] * A[j]) {
                rel[index--] = A[i] * A[i];
                i++;
            } else {
                rel[index--] = A[j] * A[j];
                j--;
            }
        }

        return rel;
    }
}
